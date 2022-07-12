package com.bchmsl.homework10

import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bchmsl.homework10.data.Product
import com.bchmsl.homework10.databinding.ActivityItemOpenedBinding

class ItemOpenedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityItemOpenedBinding
    private lateinit var item: Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemOpenedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        listeners()
        setItem()
    }

    private fun listeners() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun setItem() {
        item = intent.getSerializableExtra("item") as Product

        binding.apply {
            ivImage.setImageResource(item.image)
            tvTitle.text = item.title
            if (item.oldPrice == null){
                tvOldPrice.visibility = View.GONE
            }else{
                tvOldPrice.apply {
                    visibility = View.VISIBLE
                    val price = "$" + item.oldPrice.toString()
                    text = price
                    setTextColor(Color.RED)
                    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                }
            }
            val price = "$" + item.price.toString()
            tvPrice.text = price
        }

    }
}