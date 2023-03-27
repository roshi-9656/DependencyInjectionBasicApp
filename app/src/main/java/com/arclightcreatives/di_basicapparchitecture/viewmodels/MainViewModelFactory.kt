package com.arclightcreatives.di_basicapparchitecture.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arclightcreatives.di_basicapparchitecture.datalayer.repositories.Repository

class MainViewModelFactory(private val repository: Repository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(Mainviewmodel::class.java)) {
            return Mainviewmodel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }



}