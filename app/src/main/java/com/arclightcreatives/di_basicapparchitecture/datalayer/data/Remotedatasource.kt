package com.arclightcreatives.di_basicapparchitecture.datalayer.data

import com.arclightcreatives.di_basicapparchitecture.datalayer.models.Repomodel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class Remotedatasource {

    fun getrepodataRemote(): Observable<ArrayList<Repomodel>> {
        var reporemoteList =ArrayList<Repomodel>()
        reporemoteList.add(Repomodel("Roshin", "2135123", "books", "close"))
        reporemoteList.add(Repomodel("Monika", "2135123", "books", "close"))
        reporemoteList.add(Repomodel("Anu", "2135123", "books", "open"))
        return Observable.just(reporemoteList).delay(2, TimeUnit.SECONDS)
    }

}