package com.example.taskmanager

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddTaskActivity : AppCompatActivity() {
    lateinit var taskNameEditText: EditText
    lateinit var cancelButton: Button
    lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        taskNameEditText = findViewById(R.id.taskNameEditText)
        cancelButton = findViewById(R.id.cancelButton)
        cancelButton.setOnClickListener{
            finish()
        }
        submitButton = findViewById(R.id.submitButton)
        submitButton.setOnClickListener {

            var taskName = taskNameEditText.text.toString()
            var intent = Intent()
            intent.putExtra("NEW_TASK_TITLE", taskName)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}