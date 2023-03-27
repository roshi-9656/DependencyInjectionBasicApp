package com.arclightcreatives.di_basicapparchitecture.datalayer.repositories

import com.arclightcreatives.di_basicapparchitecture.datalayer.data.Localdatasource
import com.arclightcreatives.di_basicapparchitecture.datalayer.data.Remotedatasource
import com.arclightcreatives.di_basicapparchitecture.datalayer.models.Repomodel
import com.arclightcreatives.di_basicapparchitecture.utils.NetManager
import io.reactivex.Observable

class Repository(private val netManager: NetManager) {

    val localdatasource = Localdatasource()
    val remotedatasource = Remotedatasource()


    fun getRepositoryData(): Observable<ArrayList<Repomodel>> {
        netManager.isConnectedToInternet?.let {
            if (it) {
                return remotedatasource.getrepodataRemote()
            }
        }
        return localdatasource.getrepodataLocal()
    }

}