package com.miu.productdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProductDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val categ = intent.getStringExtra("CAT")
        supportActionBar?.title = categ


    }
}