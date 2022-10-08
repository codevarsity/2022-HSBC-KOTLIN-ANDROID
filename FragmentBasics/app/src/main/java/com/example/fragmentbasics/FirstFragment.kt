package com.example.fragmentbasics

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentActivity

class FirstFragment : Fragment() {

    lateinit var showSecondButton:Button
    var mesageFromSecond:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var fragmentView = inflater.inflate(R.layout.fragment_first, container, false)
        //get access to the show second button
        showSecondButton = fragmentView.findViewById(R.id.showSecondButton)
        showSecondButton.setOnClickListener {
            //load the second fragment
            showSecondFragment()
        }

        return fragmentView
    }

    fun showSecondFragment() {
        var secondFragment = SecondFragment()

        var bundle = Bundle()
        bundle.putString("MESSAGE", "This is a message from first fragment")
        //attach the bundle as arguments for the fragment
        secondFragment.arguments = bundle

        //setup a relationship between first fragment and second fragment
        secondFragment.setTargetFragment(this, 101)

        var transaction = fragmentManager?.beginTransaction()
        transaction
            ?.remove(this)
            ?.add(R.id.mainLayout, secondFragment, "Second Fragment")
            ?.addToBackStack("back to first")
            ?.commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if( requestCode == 101 && resultCode == Activity.RESULT_OK && data != null) {
            var messageFromSecond = data.extras?.get("SECOND_FRAGMENT_MESSAGE")

        }
    }

}