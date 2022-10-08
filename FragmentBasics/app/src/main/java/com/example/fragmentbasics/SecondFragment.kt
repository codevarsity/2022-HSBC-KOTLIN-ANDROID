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


class SecondFragment() : Fragment() {
    lateinit var backButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var fragmentView = inflater.inflate(R.layout.fragment_second, container, false)
        backButton = fragmentView.findViewById(R.id.backButton)
        backButton.setOnClickListener {
            //send data back to the first fragment
            var intent = Intent()
            intent.putExtra("SECOND_FRAGMENT_MESSAGE",
                            "This is a message from second fragment")
            targetFragment?.onActivityResult(101, Activity.RESULT_OK, intent)

            fragmentManager?.popBackStack()
        }

        var messageFromFirst = arguments?.get("MESSAGE")
        Log.i("SecondFragment", "$messageFromFirst")
        return fragmentView
    }

}