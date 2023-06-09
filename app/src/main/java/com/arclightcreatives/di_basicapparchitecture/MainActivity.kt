package com.arclightcreatives.di_basicapparchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arclightcreatives.di_basicapparchitecture.adapters.RecyclerAdapter
import com.arclightcreatives.di_basicapparchitecture.databinding.ActivityMainBinding
import com.arclightcreatives.di_basicapparchitecture.datalayer.models.Repomodel
import com.arclightcreatives.di_basicapparchitecture.datalayer.repositories.Repository
import com.arclightcreatives.di_basicapparchitecture.di.Injection
import com.arclightcreatives.di_basicapparchitecture.utils.NetManager
import com.arclightcreatives.di_basicapparchitecture.viewmodels.MainViewModelFactory
import com.arclightcreatives.di_basicapparchitecture.viewmodels.Mainviewmodel

class MainActivity : AppCompatActivity() {
    private lateinit var mainviewmodel: Mainviewmodel
    private lateinit var mainBinding: ActivityMainBinding
    private val repositoryRecyclerViewAdapter = RecyclerAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var mainViewModelFactory =Injection.provideMainviewmodelfactory(application)
        mainviewmodel = ViewModelProvider(this,mainViewModelFactory).get(Mainviewmodel::class.java)
        mainBinding.viewmodel =mainviewmodel
        mainBinding.executePendingBindings()

        mainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mainBinding.recyclerView.adapter=repositoryRecyclerViewAdapter

        mainviewmodel.dataViewmodel.observe(this,
            Observer<ArrayList<Repomodel>> {
                it?.let{ repositoryRecyclerViewAdapter.replace(it)} })

    }
}