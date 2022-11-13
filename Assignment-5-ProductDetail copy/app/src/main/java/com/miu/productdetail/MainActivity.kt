package com.miu.productdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }

    fun categoryDetail(cat: String) {
        val int = Intent(this, ProductDetail::class.java)
        int.putExtra("CAT", cat)
        startActivity(int)
    }

    fun onClick(v: View?) {
        when (v?.id) {
            R.id.electronic -> categoryDetail("Electronics")
            R.id.clothing -> Toast.makeText(applicationContext, "You have chosen the Clothing category of shopping", Toast.LENGTH_SHORT).show()
            R.id.beaty -> Toast.makeText(applicationContext, "You have chosen the Beauty category of shopping", Toast.LENGTH_SHORT).show()
            R.id.food -> Toast.makeText(applicationContext, "You have chosen the Food category of shopping", Toast.LENGTH_SHORT).show()
        }
    }
}