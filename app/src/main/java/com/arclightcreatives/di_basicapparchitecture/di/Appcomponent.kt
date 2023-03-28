package com.arclightcreatives.di_basicapparchitecture.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        Appmodule::class,MainActivityModule::class])
interface AppComponent : AndroidInjector<DIapplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DIapplication>()
}