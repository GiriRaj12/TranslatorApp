package com.example.messagingapp

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.messagingapp.DataObjects.UserTranslation
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_addtranslate.*
import java.util.*

class TranslatorPageActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtranslate);
        addTransLationButton.setOnClickListener(){
            var userName = intent.getStringExtra("userName");
            var englishWord = englishWord.text.toString();
            var convertedWord = convertedWord.text.toString();
            createAndSaveWord(englishWord,convertedWord,userName);
        }
    }
    private fun createAndSaveWord(englishWor:String,convertedWord:String,userName:String){
        var user = UserTranslation(userName,englishWor,convertedWord);
        Log.d("pageActivity",user.username+"->"+user.englishQ+"->"+user.convertedQ);
        var dataBase = FirebaseFirestore.getInstance();
        dataBase.collection("/Translations")
            .document("/"+userName+ UUID.randomUUID())
            .set(user)
            .addOnSuccessListener {
                Toast.makeText(this@MainPageActivity,"Saved", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener(){
                Toast.makeText(this@MainPageActivity,"Not Saved", Toast.LENGTH_SHORT).show();
            }
    }
}
