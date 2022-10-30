package com.miu.tablayout

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.setPadding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addClick(view: View) {
        if (code_version.text.isEmpty() || code_name.text.isEmpty()) {
            Toast.makeText(applicationContext, "Code version or Code name value must be filled!", Toast.LENGTH_LONG).show()
        } else {
            val row = TableRow(applicationContext)
            val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
            row.layoutParams = layoutParams

            val version_column = TextView(this)
            version_column.text = code_version.text.toString()
            version_column.setBackgroundColor(Color.parseColor("#FFBB86FC"))

            val code_column = TextView(this)
            code_column.text = code_name.text.toString()
            code_column.setBackgroundColor(Color.parseColor("#FFBB86FC"))

            row.addView(version_column)
            row.addView(code_column)
            row.setPadding(10, 0, 10, 10)
            table.addView(row)

            code_version.text.clear()
            code_name.text.clear()
            Toast.makeText(applicationContext, "Added new row", Toast.LENGTH_LONG).show()
        }
    }
}