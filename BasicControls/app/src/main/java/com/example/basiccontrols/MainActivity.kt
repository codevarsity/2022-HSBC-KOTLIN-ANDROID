package com.example.basiccontrols

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    lateinit var checkBox: CheckBox
    lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkBox = findViewById(R.id.checkBox)
        checkBox.setOnClickListener{

        }

        checkBox.setOnCheckedChangeListener { button, checkBoxState ->
            if(checkBoxState == true) {
                Log.i("MainActivity", "CheckBox On")
            } else {
                Log.i("MainActivity", "CheckBox Off")
            }
        }

        seekBar = findViewById(R.id.seekBar)
        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                Log.i("MainActivity","Seek Bar value = $p1")
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }
}