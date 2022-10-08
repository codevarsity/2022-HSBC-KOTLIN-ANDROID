package com.example.recyclerviewexample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var cityNameTextView:TextView = itemView.findViewById(R.id.cityNameTextView)
}