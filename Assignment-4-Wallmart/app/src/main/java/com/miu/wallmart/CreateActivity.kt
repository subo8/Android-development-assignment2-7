package com.miu.wallmart

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity: AppCompatActivity() {
    private var user: User = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        supportActionBar?.hide()

        create_btn.setOnClickListener {
            setInputValues()
            if(user.firstName.isEmpty() || user.lastName.isEmpty() || user.userName.isEmpty() || user.passWord.isEmpty()) {
                Toast.makeText(applicationContext, "All fields must be filled!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Created successfully!", Toast.LENGTH_SHORT).show()
                val intent = Intent()
                intent.putExtra("user", user)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    private fun setInputValues() {
        user.userName = email.text.toString()
        user.lastName = lastName.text.toString()
        user.passWord = password.text.toString()
        user.firstName = firstName.text.toString()
    }
}
