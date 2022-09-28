package com.example.countryapp

import android.content.Context
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CountryAdapter(var countriesArray:ArrayList<String>, var context: Context) : BaseAdapter() {

    //View Holder class
    class ViewHolder {
        lateinit var imageView:ImageView
        lateinit var textView:TextView
    }


    override fun getCount(): Int {
        return countriesArray.size
    }

    override fun getItem(p0: Int): Any {
        return countriesArray.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var itemText = countriesArray.get(p0)
        var mainView:View? = null
        if(p1 == null) {
            Log.i("MainActivity", "getView($p0)")
            mainView =
                LayoutInflater.from(context).inflate(R.layout.country_row_layout, null)

            //create teh view holder
            var viewHolder = ViewHolder()
            //initialize the properties of view holder to hold references of objects in the view
            viewHolder.imageView = mainView.findViewById<ImageView>(R.id.flagImageView)
            viewHolder.textView = mainView.findViewById(R.id.countryNameTextView)
            mainView.tag = viewHolder
        } else {
            mainView = p1
        }

        //once we have a View we can get th View holder from the View
        var viewHolder = mainView?.tag as? ViewHolder
        viewHolder?.textView?.text = itemText

        return mainView!!

    }
}