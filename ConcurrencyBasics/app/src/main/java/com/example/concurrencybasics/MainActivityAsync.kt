package com.example.concurrencybasics

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import java.net.URL

class MainActivityAsync : AppCompatActivity() {

    lateinit var imageView: ImageView
    lateinit var downloadButton:Button

    val link = "https://upload.wikimedia.org/wikipedia/commons/3/3e/Android_logo_2019.png?20190822201450"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        downloadButton = findViewById(R.id.downloadImageButton)
        downloadButton.setOnClickListener {
            var task = ImageDownloaderTask(imageView)
            task.execute(link)
        }
    }



}