package com.example.recyclerviewexample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CitiesAdapter(var context: Context,
                    var cities:ArrayList<String>) :
                                    RecyclerView.Adapter<CitiesViewHolder>(){
    //this method is only called when a view is to be created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        //inflate the view
        var view = LayoutInflater.from(context).inflate(R.layout.cities_row_layout, null)
        //create the ViewHolder for the View
        var viewHolder = CitiesViewHolder(view)
        //return the viewholder
        return viewHolder
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        //get the item from the array at position
        var cityName = cities.get(position)

        //update the view using holder
        holder.cityNameTextView.text = cityName
    }

    override fun getItemCount(): Int {
        return cities.size
    }
}