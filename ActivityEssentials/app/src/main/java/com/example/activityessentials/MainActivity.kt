package com.example.activityessentials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var nameEditTExt:EditText
    lateinit var button: Button
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "MainActivity::onCreate")
        setContentView(R.layout.activity_main)

        nameEditTExt = findViewById(R.id.editTextTextPersonName)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button.setOnClickListener{
            val userText = nameEditTExt.getText()
            textView.setText(userText)

            //launch the second activity
            var intent = Intent(this, SecondActivity::class.java)
            //attach extras to the intent
            intent.putExtra("USER_TEXT", nameEditTExt.text.toString())
            //launch activity using the intent
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "MainActivity::onResume()")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "MainActivity::onStart()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "MainActivity::onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "MainActivity::onStop")
    }
}