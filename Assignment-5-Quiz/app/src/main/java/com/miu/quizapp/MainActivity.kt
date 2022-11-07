package com.miu.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val correctAnswers = hashMapOf<String, Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Quiz App"

        correctAnswers[getString(R.string.answer12)] = 50
        correctAnswers[getString(R.string.answer22)] = 50


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val checked = group.findViewById(checkedId) as RadioButton
            if (checked.isChecked) {
                if(checked.text.toString() == getString(R.string.answer12)) {

                }
            }
        }
    }
}