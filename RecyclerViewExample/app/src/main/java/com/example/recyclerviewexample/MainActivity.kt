package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var citiesRecyclerView: RecyclerView

    var cities = ArrayList<String>()
    lateinit var citiesAdapter:CitiesAdapter

    fun initializeCities() {
        cities.add("Pune")
        cities.add("New Delhi")
        cities.add("Gurugram")
        cities.add("Jaipur")
        cities.add("Pune")
        cities.add("New Delhi")
        cities.add("Gurugram")
        cities.add("Jaipur")
        cities.add("Pune")
        cities.add("New Delhi")
        cities.add("Gurugram")
        cities.add("Jaipur")
        cities.add("Pune")
        cities.add("New Delhi")
        cities.add("Gurugram")
        cities.add("Jaipur")
        cities.add("Pune")
        cities.add("New Delhi")
        cities.add("Gurugram")
        cities.add("Jaipur")
        cities.add("Pune")
        cities.add("New Delhi")
        cities.add("Gurugram")
        cities.add("Jaipur")





    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeCities()

        citiesRecyclerView = findViewById(R.id.citiesRecyclerView)

        var layoutManager = LinearLayoutManager(this,
                                                LinearLayoutManager.VERTICAL,
                                                false)
        citiesRecyclerView.layoutManager = layoutManager

        citiesAdapter = CitiesAdapter(this, cities)
        citiesRecyclerView.adapter = citiesAdapter

    }
}