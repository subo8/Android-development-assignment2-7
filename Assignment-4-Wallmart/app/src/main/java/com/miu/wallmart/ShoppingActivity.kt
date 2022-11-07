package com.miu.wallmart

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        supportActionBar?.title = "Shop by Categories"

        var email = intent.getStringExtra("email")
        logged.text = email
    }

    fun onClick(v: View?) {
        when (v?.id) {
            R.id.electronic -> Toast.makeText(applicationContext, "You have chosen the Electronic category of shopping", Toast.LENGTH_SHORT).show()
            R.id.clothing -> Toast.makeText(applicationContext, "You have chosen the Clothing category of shopping", Toast.LENGTH_SHORT).show()
            R.id.beaty -> Toast.makeText(applicationContext, "You have chosen the Beauty category of shopping", Toast.LENGTH_SHORT).show()
            R.id.food -> Toast.makeText(applicationContext, "You have chosen the Food category of shopping", Toast.LENGTH_SHORT).show()
        }
    }
}