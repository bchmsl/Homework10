package com.bchmsl.homework10.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bchmsl.homework10.data.D
import com.bchmsl.homework10.data.Filters
import com.bchmsl.homework10.databinding.LayoutCategoryBinding

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
        val currentItem = categories[position]
        onBind(holder.binding, currentItem)
    }

    override fun getItemCount(): Int = categories.size


    private fun onBind(binding: LayoutCategoryBinding, currentItem: Filters.Category) {
        binding.root.apply {
            text = currentItem.categoryName
            selectCategory(this@apply, currentItem)
            binding.root.setOnClickListener { onClick(currentItem) }
        }
    }

    private fun selectCategory(view: AppCompatTextView, currentItem: Filters.Category) {
        if (currentItem.selected) {
            view.setBackgroundResource(D.category_selected)
        } else {
            view.setBackgroundResource(D.category_unselected)
        }
    }
}