package com.example.helloandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity() {

    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inflate the xml layout
        var mainView = LayoutInflater.from(this).inflate(R.layout.activity_main, null)

        //attach the view to the activity as content view
        setContentView(mainView)
       // setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        button?.setOnClickListener {
            Log.i("MainActivity", "Button Tapped")

            //create the second activity
            var intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)


        }
    }
}