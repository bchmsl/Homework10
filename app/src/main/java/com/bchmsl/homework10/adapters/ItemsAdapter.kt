package com.bchmsl.homework10.adapters

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bchmsl.homework10.data.Product
import com.bchmsl.homework10.databinding.LayoutItemBinding

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {
    inner class ItemsViewHolder(val binding: LayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.image == newItem.image
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder =
        ItemsViewHolder(
            LayoutItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        bind(holder, position)
    }

    override fun getItemCount(): Int = differ.currentList.size

    private fun bind(holder: ItemsViewHolder, position: Int) {
        val currentItem = differ.currentList[position]
        holder.binding.apply {
            tvTitle.text = currentItem.title
            val oldPrice = "$" + currentItem.price.toString()
            tvPrice.text = oldPrice
            ivImageValue.apply {
                setImageResource(currentItem.image)
            }
            if (currentItem.oldPrice != null) {
                tvOldPrice.apply {
                    visibility = View.VISIBLE
                    val price = "$" + currentItem.oldPrice.toString()
                    text = price
                    setTextColor(Color.RED)
                    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                }
            } else {
                tvOldPrice.visibility = View.GONE
            }
        }
    }

//    fun updateRV(newProductsList: List<Product>) {
//        val diffUtil = ItemsDiffUtil(selectedProductsList, newProductsList)
//        val diffResults = DiffUtil.calculateDiff(diffUtil)
//        selectedProductsList = newProductsList as MutableList<Product>
//        diffResults.dispatchUpdatesTo(this)
//    }
}