package com.arclightcreatives.di_basicapparchitecture.di

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class DIapplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}