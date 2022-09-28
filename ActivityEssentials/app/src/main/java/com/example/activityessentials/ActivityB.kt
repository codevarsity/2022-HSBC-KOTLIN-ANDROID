package com.example.activityessentials

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ActivityB : AppCompatActivity() {

    lateinit var messageEditText: EditText
    lateinit var submitButton: Button
    lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        messageEditText = findViewById(R.id.messageEditText)
        submitButton = findViewById(R.id.submitButton)
        submitButton.setOnClickListener{
            //get the text typed by user
            var message = messageEditText.text.toString()
            var intent = Intent()
            intent.putExtra("MESSAGE", message)

            //send intent to the parent activity
            setResult(Activity.RESULT_OK, intent)

            finish()

        }

        cancelButton = findViewById(R.id.cancelButton)
        cancelButton.setOnClickListener {
            finish()
        }
    }
}