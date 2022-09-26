package com.example.alphaacemobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alphaacemobile.databinding.HomeNewsItemBinding
import com.example.alphaacemobile.databinding.HomeTopItemBinding
import com.example.alphaacemobile.model.HomeNewsModel
import com.example.alphaacemobile.model.HomeTopModel

class HomeTopAdapter (
    private val homeTopList: ArrayList<HomeTopModel>,
    private val listener: (HomeTopModel, Int) -> Unit
) : RecyclerView.Adapter<HomeTopAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = HomeTopItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(homeTopList[position])
        holder.itemView.setOnClickListener {
            listener(homeTopList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return homeTopList.size
    }

    class ViewHolder(var itemBinding: HomeTopItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(top: HomeTopModel) {
            itemBinding.tvHomeTopRank.text = top.rank
            itemBinding.tvHomeTopName.text = top.name
            itemBinding.tvHomeTopPrice.text = top.price
            itemBinding.tvHomeTopMarketCap.text = top.market
            itemBinding.ivHomeTopStatistics.setImageResource(top.statistics)
        }
    }
}