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
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var loginButton = findViewById(R.id.loginButton) as Button
        loginButton.setOnClickListener{
            checkInput();
        };
        registerText.setOnClickListener(){
            registerHandler();
        }

    }

    fun checkInput() {
        var email = emailInput.text.toString();
        var password = passwrdInput.text.toString();
        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(this@MainActivity, "Feilds cannot be empty", Toast.LENGTH_SHORT).show();
        }
        userLogin(email, password);
    }

    fun registerHandler(){
        var intent = Intent(this,RegisterActivity::class.java)
        intent.putExtra("something","somthing")
            startActivity(intent)
    }

    private fun userLogin(email:String,password:String){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                val intent = Intent(this,MainPageActivity::class.java)
                startActivity(intent);
            }
            .addOnFailureListener{
                Toast.makeText(this@MainActivity,"Username or password wrong",Toast.LENGTH_SHORT).show()
            }
    }
}
