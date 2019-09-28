package com.example.messagingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.support.*;
import kotlinx.android.synthetic.main.activity_mainpage.*

class MainPageActivity : AppCompatActivity(){
    var translations : ArrayList<String> = ArrayList();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainpage)
        addTranslations()
        translationList
    }

    fun addTranslations(){
        translations.add("Something")
        translations.add("Nothing")
    }

}
