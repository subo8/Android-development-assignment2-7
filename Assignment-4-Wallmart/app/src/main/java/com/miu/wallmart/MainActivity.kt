package com.miu.wallmart

import android.content.Intent
import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var users = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //hiding action bar with title
        supportActionBar?.hide()

        //add sample users to arrayList
        users.add(User("Byambadorj", "Batsukh", "bbatsukh@miu.edu", "Test123!"))
        users.add(User("John", "Doe", "johnd@miu.edu", "Test123!"))
        users.add(User("Jane", "Doe", "jane@miu.edu", "Test123!"))
        users.add(User("John", "Lennon", "jLennong@miu.edu", "Test123!"))
        users.add(User("s1mple", "s1mple", "s1mple@miu.edu", "Test123!"))

        login.setOnClickListener {
            if (username.text.toString() != "" &&  password.text.toString() !="") {
                for (user in users) {
                    if(user.userName == username.text.toString() && user.passWord == password.text.toString()) {
                        val shoppingIntent = Intent(this,ShoppingActivity::class.java )
                        shoppingIntent.putExtra("email", username.text.toString())
                        startActivity(shoppingIntent)
                    } else {
                        Toast.makeText(applicationContext, "Check credentials!!", Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                Toast.makeText(applicationContext, "Inputs must not be null!", Toast.LENGTH_LONG).show()
            }
        }

        button2.setOnClickListener {
            val createIntent = Intent(this, CreateActivity:: class.java)
            resultLauncher.launch(createIntent)
        }
    }

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val serUser = data!!.getSerializableExtra("user")
            val newUser = serUser as User
            users.add(newUser)
        }
    }

    private fun findUserByEmail(email: String): User {
        for (user in users) {
            if (user.userName == email) {
                return user
            }
        }
        return User()
    }

    fun forgot(view: View) {
        val email = username.text.toString()
        val found = findUserByEmail(email)

        if (found.passWord.isNotEmpty()) {
            val int = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))
            int.putExtra(Intent.EXTRA_EMAIL, arrayListOf(email))
            int.putExtra(Intent.EXTRA_SUBJECT, "Recover password")
            int.putExtra(Intent.EXTRA_TEXT, "Your password: ${found.passWord}")
            startActivity(Intent.createChooser(intent, "Send email:"))
        } else {
            Toast.makeText(applicationContext, "User not found!", Toast.LENGTH_LONG).show()
        }
    }
}