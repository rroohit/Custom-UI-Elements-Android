package com.roh.practice.ui.main.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.roh.practice.databinding.ItemHomeBinding
import com.roh.practice.domain.model.HomeItem

class HomeItemAdapter(
    val onItemClickListener: OnItemClickListener
) : ListAdapter<HomeItem, HomeItemAdapter.ViewHolder>(HomeItemDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val homeItem = getItem(position)
        holder.bind(homeItem)
    }

    inner class ViewHolder constructor(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(homeItem: HomeItem) {
            binding.txtTitle.text = homeItem.CardName



            binding.itemContainer.setOnClickListener {
                onItemClickListener.onItemClick(homeItem)
            }


        }

    }

}

interface OnItemClickListener {
    fun onItemClick(homeItem: HomeItem)
}

class HomeItemDiffUtilCallback : DiffUtil.ItemCallback<HomeItem>() {
    override fun areItemsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
        return oldItem.CardId == newItem.CardId
    }

    override fun areContentsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
        return oldItem == newItem
    }


}