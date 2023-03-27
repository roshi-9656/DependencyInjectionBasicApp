package com.arclightcreatives.di_basicapparchitecture.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arclightcreatives.di_basicapparchitecture.databinding.RecyclerrowBinding
import com.arclightcreatives.di_basicapparchitecture.datalayer.models.Repomodel

class RecyclerAdapter(private var items: ArrayList<Repomodel>) :
    RecyclerView.Adapter<RecyclerAdapter.Viewholder>() {

    class Viewholder(private var binding: RecyclerrowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repoModel: Repomodel) {
            binding.repomodel = repoModel
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = RecyclerrowBinding.inflate(layoutInflater, parent, false)
        return Viewholder(binding)
    }

    override fun getItemCount(): Int {
        println("items = ${items.size}")
        return items.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bind(items[position])
    }

    fun replace(itemlist: ArrayList<Repomodel>){
        items = itemlist
        notifyDataSetChanged()
    }

}