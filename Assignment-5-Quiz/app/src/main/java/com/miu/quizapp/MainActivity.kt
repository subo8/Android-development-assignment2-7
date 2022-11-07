package com.miu.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private val correctAnswers = hashMapOf<String, Int>()
    private val option = hashSetOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        correctAnswers[getString(R.string.answer12)] = 50
        correctAnswers[getString(R.string.answer22)] = 50


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val checked = group.findViewById(checkedId) as RadioButton
            if (checked.isChecked) {
                if(checked.text.toString() == getString(R.string.answer12)) {
                    option.add(checked.text.toString())
                } else {
                    option.remove(getString(R.string.answer12))
                }
            }
        }

        ans21.setOnCheckedChangeListener { view, isChecked ->
            if(isChecked) {
                option.add(getString(R.string.answer21))
            } else {
                option.remove(getString(R.string.answer21))
            }
        }

        ans22.setOnCheckedChangeListener { view, isChecked ->
            if(isChecked) {
                option.add(getString(R.string.answer22))
            } else {
                option.remove(getString(R.string.answer22))
            }
        }

        ans23.setOnCheckedChangeListener { view, isChecked ->
            if(isChecked) {
                option.add(getString(R.string.answer23))
            } else {
                option.remove(getString(R.string.answer23))
            }
        }

        reset.setOnClickListener {
            var radioButton = findViewById<RadioButton>(radioGroup.checkedRadioButtonId);
            if(radioButton.isChecked) radioButton.isChecked = false
            ans21.isChecked = false
            ans22.isChecked = false
            ans23.isChecked = false
            option.clear()
        }

        submit.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Congratulations!")
            val dataFormat = SimpleDateFormat("M/dd, hh:mm:ss")
            val dateTime = dataFormat.format(Date())
            builder.setMessage("""
                You submitted on: $dateTime
                Your achieved: ${calculation()}
            """.trimIndent())
            builder.setPositiveButton("Close"){dialogInterface, which ->
                dialogInterface.dismiss()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    private fun calculation():Int {
        var points = 0;
        for (item in option) {
            if (correctAnswers.containsKey(item)) {
                points += correctAnswers[item]!!
            }
        }
        return points;
    }

}