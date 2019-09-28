package com.example.messagingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.emailInput
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var loginButton = findViewById(R.id.loginButton) as Button
        loginButton.setOnClickListener{
            checkInput()
        };
        registerText.setOnClickListener(){
            registerHandler()
        }
    }

    private fun checkInput() {
        Log.i("MainActivity","Came into check")
        var email = emailInput.text.toString();
        var password = passwrdInput.text.toString();
        print(email+""+password)
        if (email.isNullOrBlank() || password.isNullOrBlank()) {
            Toast.makeText(this@MainActivity, "Feilds cannot be empty", Toast.LENGTH_SHORT).show()
        }
        else
            userLogin(email, password)
    }

    private fun registerHandler(){
        var intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
    }

    private fun userLogin(email:String,password:String){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                val intent = Intent(this,MainPageActivity::class.java)
                intent.putExtra("userName",email);
                startActivity(intent)
            }
            .addOnFailureListener{
                Toast.makeText(this@MainActivity,"Username or password wrong",Toast.LENGTH_SHORT).show()
            }
    }
}
