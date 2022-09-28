package com.example.taskmanager

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class AddTaskFragment : Fragment() {

    lateinit var taskNameEditText: EditText
    lateinit var cancelButton: Button
    lateinit var submitButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var fragmentView = inflater.inflate(R.layout.fragment_add_task, container, false)

        taskNameEditText = fragmentView.findViewById(R.id.taskNameEditText)
        cancelButton = fragmentView.findViewById(R.id.cancelButton)
        cancelButton.setOnClickListener{
            fragmentManager?.popBackStack()
        }
        submitButton = fragmentView.findViewById(R.id.submitButton)
        submitButton.setOnClickListener {

            var taskName = taskNameEditText.text.toString()
            var intent = Intent()
            intent.putExtra("NEW_TASK_TITLE", taskName)
            targetFragment?.onActivityResult(101, Activity.RESULT_OK, intent)

            fragmentManager?.popBackStack()
        }

        return fragmentView
    }
}