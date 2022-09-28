package com.example.taskmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TaskListActivity : AppCompatActivity() {
    lateinit var addTaskButton: Button
    lateinit var taskRecyclerView: RecyclerView
    lateinit var taskAdapter:TaskAdapter

    var taskList:ArrayList<String> = ArrayList<String>()

    fun initializeTaskList() {
        taskList.add("Get Milk")
        taskList.add("Attend Android Training")
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

        taskAdapter = TaskAdapter(this, taskList)
        //get a reference to the recycler view that will display the tasks
        taskRecyclerView = findViewById(R.id.taskRecyclerView)

        //create layout manager
        var layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //attach the layout manager to the recycler view
        taskRecyclerView.layoutManager = layoutManager
        //attach the adapter to the recycler view
        taskRecyclerView.adapter = taskAdapter

        addTaskButton = findViewById(R.id.addNewTaskButton)
        addTaskButton.setOnClickListener{
            var intent = Intent(this@TaskListActivity, AddTaskActivity::class.java)
            startActivityForResult(intent, 101)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if( requestCode == 101 && resultCode == RESULT_OK && data != null) {
            var task = data.extras?.getString("NEW_TASK_TITLE")
            if (task != null) {
                taskList.add(task)
            }
        }
        //refresh the recycler view
        taskAdapter.notifyDataSetChanged()
    }


}