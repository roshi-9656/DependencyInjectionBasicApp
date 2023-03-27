package com.arclightcreatives.di_basicapparchitecture.datalayer.data

import com.arclightcreatives.di_basicapparchitecture.datalayer.models.Repomodel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class Localdatasource {


    fun getrepodataLocal():Observable<ArrayList<Repomodel>>{
        var repolocaldataList =ArrayList<Repomodel>()
        repolocaldataList.add(Repomodel("Roshin", "2135123", "books", "close"))
        repolocaldataList.add(Repomodel("Monika", "2135123", "books", "close"))
        repolocaldataList.add(Repomodel("Anu", "2135123", "books", "open"))
        return Observable.just(repolocaldataList).delay(2,TimeUnit.SECONDS)
    }
}