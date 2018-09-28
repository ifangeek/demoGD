package com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diegojosuepachecorosas.gdwnewarchitecture.R
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.model.FilesVM
import kotlinx.android.synthetic.main.item_file.view.*

class RVFilesAdapter : RecyclerView.Adapter<RVFilesAdapter.ViewHolder>() {

    var isLoading: Boolean = false

    var data: MutableList<FilesVM> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_file, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(data[position])
    }

    fun addListFiles(listFilesVM: List<FilesVM>) {
        data.addAll(listFilesVM)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(model: FilesVM) {
            itemView.tvNameFile.text = model.name
            itemView.tvMimetype.text = model.mimetype
        }
    }
}