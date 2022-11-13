package com.miu.productdetail

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*


class ProductDetail : AppCompatActivity() {
//    lateinit var strings: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val categ = intent.getStringExtra("CAT")
        supportActionBar?.title = categ

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.electronics))

        list.adapter = adapter
        list.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
        }

    }
}