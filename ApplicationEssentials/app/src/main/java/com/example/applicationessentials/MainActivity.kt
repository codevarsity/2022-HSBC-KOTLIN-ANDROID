package com.example.applicationessentials

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var phoneCallButton:Button? = null
    var takePictureButton:Button? = null
    var browseWebButton:Button? = null
    var launchMainButton:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        phoneCallButton = findViewById(R.id.makePhoneCallButton)
        phoneCallButton?.setOnClickListener{
            var intent = Intent(Intent.ACTION_DIAL)
            startActivity(intent)

        }

        takePictureButton = findViewById(R.id.takePictureButton)
        takePictureButton?.setOnClickListener{
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        browseWebButton = findViewById(R.id.browseWebButton)
        browseWebButton?.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("http://www.google.com"))
            startActivity(intent)
        }

        launchMainButton = findViewById(R.id.launchMainButton)
        launchMainButton?.setOnClickListener {
            var intent = Intent(this@MainActivity, MainActivity::class.java)
            startActivity(intent)
        }


    }
}