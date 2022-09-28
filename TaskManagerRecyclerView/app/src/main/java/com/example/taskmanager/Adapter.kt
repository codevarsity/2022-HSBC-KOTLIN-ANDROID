package com.example.taskmanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var titleTextView:TextView = itemView.findViewById(R.id.textView)
}

class TaskAdapter(var context:Context, var tasks:ArrayList<String>) : RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.task_item_row, null)
        var viewHolder = TaskViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        //get the task item from the tasks array
        var item = tasks[position]

        //display the task item on the text view
        holder.titleTextView.text = item
    }

    override fun getItemCount(): Int {
       return tasks.size
    }
}