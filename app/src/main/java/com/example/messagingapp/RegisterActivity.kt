package com.example.messagingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registerButton.setOnClickListener(){
            checkInput();
        }

        aldreadyHaveAccountText.setOnClickListener(){
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    fun checkInput(){
        var name = nameInput.text.toString()
        var email = emailInput.text.toString()
        var passwrd = passwordInput.text.toString()

        if(name.isNullOrBlank() || email.isNullOrBlank() || passwrd.isNullOrBlank()) {
            Toast.makeText(
                this@RegisterActivity,
                "Input Feilds cannot be empty",
                Toast.LENGTH_SHORT
            ).show()
        }
        else{
            println(email+""+passwrd);
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, passwrd)
                .addOnCompleteListener() {
                    if (!it.isSuccessful()) return@addOnCompleteListener
                    Toast.makeText(
                        this@RegisterActivity,
                        "Registered now login",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
                .addOnFailureListener() {
                    Toast.makeText(this@RegisterActivity, "Not Registered", Toast.LENGTH_SHORT);
                }
        }

    }

}