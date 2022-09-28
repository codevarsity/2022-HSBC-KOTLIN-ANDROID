package com.example.activityessentials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    var backButton:Button? = null
    var userMessageTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        userMessageTextView = findViewById(R.id.userMessageTextView)
        backButton = findViewById(R.id.backButton)
        backButton?.setOnClickListener {
            //destroy the second activity, so that we can go back to the main activity
            finish()
        }

        ///get access to the launching intent of this activity
        var launchingIntent = this.intent

        //get access to extras attached to the launching intent
        var userMessage = launchingIntent.extras?.getString("USER_TEXT")

        //display the user message on the text view
        userMessageTextView?.text = userMessage

    }
}