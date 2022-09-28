package com.example.taskmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TaskListActivity : AppCompatActivity() {
    lateinit var addTaskButton: Button
    lateinit var taskListTextView: TextView

    var taskList:ArrayList<String> = ArrayList<String>()

    fun initializeTaskList() {
        taskList.add("Get Milk")
        taskList.add("Attend Android Training")
    }


    fun getTaskListAsString():String {
        var stringBuilder = StringBuilder()
        for (task in taskList) {
            stringBuilder.append(task)
            stringBuilder.append("\n")
        }
        return stringBuilder.toString()
    }

    fun updateUI() {
        //convert the task list array into a string
        var tasksString = getTaskListAsString()
        //display the string containing all tasks in text view
        taskListTextView.text = tasksString
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("TASK_LIST", taskList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        if (savedInstanceState == null) {
            initializeTaskList()
        } else {
            var savedList = savedInstanceState.getStringArrayList("TASK_LIST")
            if (savedList != null) {
                taskList = savedList
            }
        }

        taskListTextView = findViewById(R.id.taskListTextView)
        addTaskButton = findViewById(R.id.addNewTaskButton)
        addTaskButton.setOnClickListener{
            var intent = Intent(this@TaskListActivity, AddTaskActivity::class.java)
            startActivityForResult(intent, 101)
        }

        updateUI()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if( requestCode == 101 && resultCode == RESULT_OK && data != null) {
            var task = data.extras?.getString("NEW_TASK_TITLE")
            if (task != null) {
                taskList.add(task)

                updateUI()
            }
        }
    }


}