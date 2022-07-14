package com.bchmsl.homework10.adapters

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bchmsl.homework10.data.Product
import com.bchmsl.homework10.data.selectedProductsList
import com.bchmsl.homework10.databinding.LayoutItemBinding

typealias onItemClick = (item : Product) -> Unit

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {


    inner class ItemsViewHolder(val binding: LayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root)




    class ItemsDiffUtilCallback(
        private val oldList: MutableList<Product>,
        private val newList: MutableList<Product>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].id == newList[newItemPosition].id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]

    }





    lateinit var onItemClick: onItemClick


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder =
        ItemsViewHolder(
            LayoutItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        onBind(holder.binding, position)
    }

    override fun getItemCount(): Int = selectedProductsList.size

    private fun onBind(binding: LayoutItemBinding, position: Int) {
        val currentItem = selectedProductsList[position]
        binding.apply {
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
            root.setOnClickListener { onItemClick(currentItem) }
        }
    }


    fun updateRV(newProductsList: List<Product>) {
        val oldProductsList = selectedProductsList
        val diffResults = DiffUtil.calculateDiff(ItemsDiffUtilCallback(oldProductsList,
            newProductsList as MutableList<Product>
        ))
        selectedProductsList = newProductsList
        diffResults.dispatchUpdatesTo(this)
    }
}