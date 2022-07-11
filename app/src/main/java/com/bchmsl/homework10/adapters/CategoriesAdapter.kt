package com.bchmsl.homework10.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bchmsl.homework10.R
import com.bchmsl.homework10.data.D
import com.bchmsl.homework10.data.Filters
import com.bchmsl.homework10.data.selectedCategoriesList
import com.bchmsl.homework10.databinding.LayoutCategoryBinding
import java.util.*

typealias onClick = (category: Filters.Category) -> Unit

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private val categories = Filters.Category.values().toList()
    lateinit var onClick: onClick

    inner class CategoriesViewHolder(val binding: LayoutCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder =
        CategoriesViewHolder(
            LayoutCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        bind(holder, position)
    }

    override fun getItemCount(): Int = categories.size

    private fun bind(holder: CategoriesViewHolder, position: Int) {
        val currentItem = categories[position]
        holder.binding.tvCategory.text = currentItem.categoryName
        if (currentItem.selected){
            holder.binding.root.setBackgroundResource(D.category_selected)
        }else{
            holder.binding.root.setBackgroundResource(D.category_unselected)
        }
        holder.binding.root.setOnClickListener { onClick(currentItem) }
    }
}