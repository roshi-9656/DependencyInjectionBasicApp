package com.arclightcreatives.di_basicapparchitecture.di

import android.content.Context
import com.arclightcreatives.di_basicapparchitecture.datalayer.repositories.Repository
import com.arclightcreatives.di_basicapparchitecture.utils.NetManager
import com.arclightcreatives.di_basicapparchitecture.viewmodels.MainViewModelFactory

object Injection {

    private var netManager: NetManager? = null

    fun providesNetmanager(context: Context): NetManager {
        if (netManager == null) {
            netManager = NetManager(context)
        }
        return netManager!!
    }

    fun provideRepository(netManager: NetManager): Repository {
        return Repository(netManager)
    }

    fun provideMainviewmodelfactory(context: Context): MainViewModelFactory {
        val networkmanager = providesNetmanager(context)
        val repository = provideRepository(networkmanager)
        return MainViewModelFactory(repository)
    }
}