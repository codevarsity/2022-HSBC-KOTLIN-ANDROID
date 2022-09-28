package com.example.taskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showTaskListFragment()
    }

    fun showTaskListFragment() {
        var taskListFragment = TaskListFragment()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.mainLayout, taskListFragment, "Task List Fragment").commit()

    }
}