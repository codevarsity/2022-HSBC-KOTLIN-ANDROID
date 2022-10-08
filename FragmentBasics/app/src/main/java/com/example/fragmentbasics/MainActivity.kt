package com.example.fragmentbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var someData:String = "Message"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load the first fragment in the activity
        showFirstFragment()
    }

    fun showFirstFragment() {
        //create an instance of the fragment
        var firstFragment = FirstFragment()

        //add the fragment to activity, for this we need a fragment manager
        //create a transaction using the fragment manager
        var transaction = supportFragmentManager.beginTransaction()
        //add fragment to activity using transaction, and commit the transaction
        transaction.add(R.id.mainLayout, firstFragment, "First Fragment").commit()
    }
}