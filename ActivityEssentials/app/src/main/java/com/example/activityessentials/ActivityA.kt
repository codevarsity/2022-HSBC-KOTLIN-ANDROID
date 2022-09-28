package com.example.activityessentials

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class ActivityA : AppCompatActivity() {

    lateinit var getMessageButton:Button
    lateinit var showMessageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity)

        showMessageTextView = findViewById(R.id.showMessageTextView)
        getMessageButton = findViewById(R.id.getMessageButton)
        getMessageButton.setOnClickListener{

            startActivityForResult(intent, 101)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 101 && resultCode == Activity.RESULT_OK && data != null) {
            //read the extras from the intent
            var message = data.extras?.getString("MESSAGE")
            //show the message on the textview
            showMessageTextView.text = message
        }

    }
}