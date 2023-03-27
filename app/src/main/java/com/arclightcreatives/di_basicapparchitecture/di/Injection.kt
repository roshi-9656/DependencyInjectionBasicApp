package com.arclightcreatives.di_basicapparchitecture.di

import android.content.Context
import com.arclightcreatives.di_basicapparchitecture.datalayer.repositories.Repository
import com.arclightcreatives.di_basicapparchitecture.utils.NetManager
import com.arclightcreatives.di_basicapparchitecture.viewmodels.MainViewModelFactory

object Injection {
    fun provideMainviewmodelfactory(context: Context) : MainViewModelFactory{
            val repository = Repository(NetManager(context))
            return MainViewModelFactory(repository)
    }
}