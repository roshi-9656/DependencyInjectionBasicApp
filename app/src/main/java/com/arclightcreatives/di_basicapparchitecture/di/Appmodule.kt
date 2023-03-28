package com.arclightcreatives.di_basicapparchitecture.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class Appmodule {

    @Provides
    fun providesContext(application: DIapplication): Context{
        return application.applicationContext
    }

    companion object{

        @Provides
        fun someTestString():String{
            return "Hello World"
        }
    }

}