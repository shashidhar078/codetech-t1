// TaskAdapter.kt
package com.example.MyTodo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodo.R


class TaskAdapter(private val tasks: MutableList<Task>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskCheckbox: CheckBox = itemView.findViewById(R.id.taskCheckbox)
        val deleteButton: Button = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.taskCheckbox.text = task.description
        holder.taskCheckbox.isChecked = task.isCompleted

        holder.taskCheckbox.setOnCheckedChangeListener { _, isChecked ->
            task.isCompleted = isChecked
        }

        holder.deleteButton.setOnClickListener {
            tasks.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}
