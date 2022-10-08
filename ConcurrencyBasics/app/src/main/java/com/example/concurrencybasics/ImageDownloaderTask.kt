package com.example.concurrencybasics

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import java.net.URL

class ImageDownloaderTask(var imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {
    override fun doInBackground(vararg args: String?): Bitmap? {
        val link = args[0]
        var bitmap:Bitmap? = null
        if ( link != null) {
            bitmap = getImage(link)
            if (bitmap != null) {
                Log.i("ImageDownloaderTask", "Image Downloaded Success")
            } else {
                Log.i("ImageDownloaderTask", "Image Downloaded Failed")
            }
        }
        return bitmap
    }

    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)

        if(result != null) {
            //set the bitmap on the imageView
            imageView.setImageBitmap(result);
        }
    }

    fun getImage(link:String):Bitmap {
        //create a URL
        val url = URL(link)
        val connection = url.openConnection()
        val inputStream = connection.getInputStream()

        //read the bytes from input stream
        val image = BitmapFactory.decodeStream(inputStream)
        return image
    }

}