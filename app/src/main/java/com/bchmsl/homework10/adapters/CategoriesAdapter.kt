package com.bchmsl.homework10.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bchmsl.homework10.data.*
import com.bchmsl.homework10.databinding.LayoutCategoryBinding

typealias onClick = (category: Filters.Category) -> Unit

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private val categories = Filters.Category.values().toList()
    lateinit var onClick: onClick

    inner class CategoriesViewHolder(val binding: LayoutCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    class CategoriesDiffUtil(
        private val oldList: List<Filters.Category>,
        private val newList: List<Filters.Category>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].categoryName == newList[newItemPosition].categoryName
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].categoryName == newList[newItemPosition].categoryName &&
                    oldList[oldItemPosition].selected == newList[newItemPosition].selected

        }

    }

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

    fun updateRV(newCategoriesList: MutableList<Filters.Category>){
        val oldCategoriesList = selectedCategoriesList
        val diffResults = DiffUtil.calculateDiff(
            CategoriesDiffUtil(
                oldCategoriesList,
                newCategoriesList
            )
        )
        selectedCategoriesList = newCategoriesList as MutableList<Filters.Category>
        diffResults.dispatchUpdatesTo(this)
    }
}