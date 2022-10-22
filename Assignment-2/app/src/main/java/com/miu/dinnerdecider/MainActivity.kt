package com.miu.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var arrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Interaction between your activity and layout
        setContentView(R.layout.activity_main)
        imageView2.setImageResource(R.drawable.dd_logo)

        arrayList.add("Hamburger")
        arrayList.add("Pizza")
        arrayList.add("Mexican")
        arrayList.add("American")
        arrayList.add("Chinese")
    }

    fun addClick(view: View) {
        val etxtVal = findViewById<EditText>(R.id.editTextNewFood)
        arrayList.add(etxtVal.text.toString())
        etxtVal.text.clear()
    }

    fun decideClick(view: View) {
        val txtVal = findViewById<TextView>(R.id.textVal)
        txtVal.text = arrayList.random()
    }
}

