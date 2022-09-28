package com.example.countryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var countryListView: ListView
    var countryNames = ArrayList<String>()
    lateinit var adapter:CountryAdapter

    fun initializeCountries() {
        countryNames.add("India")
        countryNames.add("Japan")
        countryNames.add("Brazil")
        countryNames.add("India")
        countryNames.add("Japan")
        countryNames.add("Brazil")
        countryNames.add("India")
        countryNames.add("Japan")
        countryNames.add("Brazil")
        countryNames.add("India")
        countryNames.add("Japan")
        countryNames.add("Brazil")
        countryNames.add("India")
        countryNames.add("Japan")
        countryNames.add("Brazil")
        countryNames.add("India")
        countryNames.add("Japan")
        countryNames.add("Brazil")
        countryNames.add("India")
        countryNames.add("Japan")
        countryNames.add("Brazil")
        countryNames.add("India")
        countryNames.add("Japan")
        countryNames.add("Brazil")
        countryNames.add("India")
        countryNames.add("Japan")
        countryNames.add("Brazil")
        countryNames.add("India")
        countryNames.add("Japan")
    }

    fun getNumber():Int {
        return 5
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeCountries()

        //create the adapter
        adapter = CountryAdapter(countryNames, this)

        countryListView = findViewById(R.id.countryListView)

        //attach the adapter to list view
        countryListView.adapter = adapter
    }
}