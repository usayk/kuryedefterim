package com.example.siparisdefterim


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.parse.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ParseAnalytics.trackAppOpenedInBackground(intent)

    }

    fun signIn (view: View) {

        ParseUser.logInInBackground(usernameText.text.toString(),passwordText.text.toString(), LogInCallback { user, e ->

            if (e!= null) {
                Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext,"Welcome " + user.username.toString(),Toast.LENGTH_LONG).show()
                val intent = Intent(applicationContext,konumlar::class.java)
                startActivity(intent)
            }

        })

    }
    fun signUp (view: View) {

        val user = ParseUser()
        user.username = usernameText.text.toString()
        user.setPassword(passwordText.text.toString())
        
        user.signUpInBackground { e: ParseException? ->
            if (e != null) {
                Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(applicationContext,"User Created",Toast.LENGTH_LONG).show()
                 val intent = Intent(applicationContext,konumlar::class.java)
                startActivity(intent)
            }
        }

    }


}