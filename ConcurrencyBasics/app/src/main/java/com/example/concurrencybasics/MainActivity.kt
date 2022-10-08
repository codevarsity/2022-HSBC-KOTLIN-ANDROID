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

class MainActivity : AppCompatActivity() {

    lateinit var imageView: ImageView
    lateinit var downloadButton:Button

    val link = "https://upload.wikimedia.org/wikipedia/commons/3/3e/Android_logo_2019.png?20190822201450"

    //handler object can only be created in a thread that has a Looper
    //handler attaches itself to the looper and message queue of the thread
    //it is created in
//    var handler = object:Handler(Looper.getMainLooper()) {
//        override fun handleMessage(msg: Message) {
//            super.handleMessage(msg)
//
//            //get the data attached to message
//            var bundle = msg.data
//            var bitmap = bundle.getParcelable<Bitmap>("IMAGE")
//            if(bitmap != null) {
//                imageView.setImageBitmap(bitmap)
//            }
//        }
//    }

    var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        downloadButton = findViewById(R.id.downloadImageButton)
        downloadButton.setOnClickListener {

            var thread2 = Thread {
                //get the image from link
                val bitmap = getImage()

                //send a message to the message queue of the main thread
                //we will do it via handler
//                val message = Message.obtain()
//                var imageBundle = Bundle()
//                imageBundle.putParcelable("IMAGE", bitmap)
//                message.setData(imageBundle)
//                message.arg1 = 101
//                handler.sendMessage(message)

                handler.post({
                    imageView.setImageBitmap(bitmap)
                })
//                handler.post {
//
//                }

            }.start()
        }
    }

    fun getImage():Bitmap {
        //create a URL
        val url = URL(link)
        val connection = url.openConnection()
        val inputStream = connection.getInputStream()

        //read the bytes from input stream
        val image = BitmapFactory.decodeStream(inputStream)
        return image
    }


}