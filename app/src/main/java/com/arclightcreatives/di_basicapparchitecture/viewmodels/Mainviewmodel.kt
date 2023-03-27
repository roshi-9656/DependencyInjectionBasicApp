package com.arclightcreatives.di_basicapparchitecture.viewmodels

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arclightcreatives.di_basicapparchitecture.datalayer.models.Repomodel
import com.arclightcreatives.di_basicapparchitecture.datalayer.repositories.Repository
import com.arclightcreatives.di_basicapparchitecture.utils.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


class Mainviewmodel(private var repository: Repository) : ViewModel() {

    var isLoading = ObservableField<Boolean>()
    var dataViewmodel = MutableLiveData<ArrayList<Repomodel>>()
    private val compositeDisposable = CompositeDisposable()


    fun getRepositorydata() {
        isLoading.set(true)
        compositeDisposable += repository.getRepositoryData()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ArrayList<Repomodel>>() {
            override fun onNext(t: ArrayList<Repomodel>){
                dataViewmodel.value=t
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
                isLoading.set(false)
            }
        })

    }


    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }


    private operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
        add(disposable)
    }

}