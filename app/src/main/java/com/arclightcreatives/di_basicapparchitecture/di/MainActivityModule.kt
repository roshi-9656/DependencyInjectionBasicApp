package com.arclightcreatives.di_basicapparchitecture.di

import com.arclightcreatives.di_basicapparchitecture.MainActivity
import com.arclightcreatives.di_basicapparchitecture.datalayer.repositories.Repository
import com.arclightcreatives.di_basicapparchitecture.viewmodels.MainViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainActivityModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        internal fun providesMainViewModelFactory(repository: Repository)
                : MainViewModelFactory {
            return MainViewModelFactory(repository)
        }
    }

    @ContributesAndroidInjector()
    internal abstract fun mainActivity(): MainActivity
}