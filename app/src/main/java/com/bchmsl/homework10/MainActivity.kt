package com.bchmsl.homework10

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import com.bchmsl.homework10.adapters.CategoriesAdapter
import com.bchmsl.homework10.adapters.ItemsAdapter
import com.bchmsl.homework10.data.Filters
import com.bchmsl.homework10.data.selectedCategoriesList
import com.bchmsl.homework10.data.productsList
import com.bchmsl.homework10.data.selectedProductsList
import com.bchmsl.homework10.databinding.ActivityMainBinding

@SuppressLint("NotifyDataSetChanged") // :)
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val categoriesAdapter by lazy { CategoriesAdapter() }
    private val itemsAdapter by lazy { ItemsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        setupRecyclers()
        listeners()
    }

    private fun setupRecyclers() {
        setupCategoriesRecycler()
        setupItemsRecycler()
    }

    private fun setupCategoriesRecycler() {
        binding.rvCategories.adapter = categoriesAdapter
    }

    private fun setupItemsRecycler() {
        binding.rvItems.adapter = itemsAdapter

        selectedProductsList.addAll(productsList)
        itemsAdapter.differ.submitList(selectedProductsList)
    }

    private fun listeners() {
        categoriesAdapter.onClick = { category ->
            clickCategory(category)
        }
        itemsAdapter.onItemClick = {
            val intent = Intent(this, ItemOpenedActivity::class.java)
            intent.putExtra("item", it)
            startActivity(intent)
        }
    }

    private fun clickCategory(category: Filters.Category) {
        if (category !in selectedCategoriesList) {
            selectedCategoriesList.add(category)
        } else {
            try {
                selectedCategoriesList.remove(category)
            } catch (e: Exception) {
                d("TAG_EXCEPTION_CATEGORY", selectedCategoriesList.toString())
            }
        }
        category.selected = category in selectedCategoriesList
        categoriesAdapter.notifyDataSetChanged()

        getProducts()
    }

    private fun getProducts() {
        selectedProductsList.clear()
        d("TAG_PRODUCTS", productsList.toString())
        productsList.forEach { product ->
            if (product.category.containsAll(selectedCategoriesList))
                selectedProductsList.add(product)
        }
        d("TAG_SELECTED_CATEGORIES", selectedCategoriesList.toString())
        d("TAG_SELECTED_PRODUCTS", selectedProductsList.toString())

        itemsAdapter.notifyDataSetChanged()

        itemsAdapter.differ.submitList(selectedProductsList)
//            itemsAdapter.updateRV(selectedProductsList)
    }
}