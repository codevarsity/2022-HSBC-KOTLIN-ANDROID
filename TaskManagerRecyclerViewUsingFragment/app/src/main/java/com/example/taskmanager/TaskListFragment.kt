package com.example.taskmanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TaskListFragment : Fragment() {

    lateinit var addTaskButton: Button
    lateinit var taskRecyclerView: RecyclerView
    lateinit var taskAdapter:TaskAdapter

    var taskList:ArrayList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeTaskList()
        taskAdapter = TaskAdapter(requireActivity(), taskList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        var fragmentView = inflater.inflate(R.layout.fragment_task_list, container, false)
        //get a reference to the recycler view that will display the tasks
        taskRecyclerView = fragmentView.findViewById(R.id.taskRecyclerView)

        //create layout manager
        var layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        //attach the layout manager to the recycler view
        taskRecyclerView.layoutManager = layoutManager
        //attach the adapter to the recycler view
        taskRecyclerView.adapter = taskAdapter

        addTaskButton = fragmentView.findViewById(R.id.addNewTaskButton)
        addTaskButton.setOnClickListener{
            Log.i("TaskListFragment", "Add Task Button Tapped")

            var addTaskFragment = AddTaskFragment()
            addTaskFragment.setTargetFragment(this@TaskListFragment, 101)
            fragmentManager
                ?.beginTransaction()
                ?.remove(this)
                ?.add(R.id.mainLayout, addTaskFragment, "Add Task Fragment")
                ?.addToBackStack(null)
                ?.commit()


        }

        return fragmentView
    }

    fun initializeTaskList() {
        taskList.add("Get Milk")
        taskList.add("Attend Android Training")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if( requestCode == 101 && resultCode == AppCompatActivity.RESULT_OK && data != null) {
            var task = data.extras?.getString("NEW_TASK_TITLE")
            if (task != null) {
                taskList.add(task)
            }
        }
        //refresh the recycler view
        taskAdapter.notifyDataSetChanged()
    }

}