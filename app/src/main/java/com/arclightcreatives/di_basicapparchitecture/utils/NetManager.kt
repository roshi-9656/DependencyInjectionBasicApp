package com.arclightcreatives.di_basicapparchitecture.utils

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetManager @Inject constructor( var applicationContext: Context) {
    private var status: Boolean? = false

    val isConnectedToInternet: Boolean?
        get() {
            val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                val network = conManager.activeNetwork
                val capabilities = conManager.getNetworkCapabilities(network)
                capabilities != null && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
            } else {
                conManager.activeNetworkInfo?.type == ConnectivityManager.TYPE_WIFI
            }
        }
}