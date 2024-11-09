// MainActivity.kt
package com.example.MyTodo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodo.R


class MainActivity : AppCompatActivity() {

    private lateinit var taskEditText: EditText
    private lateinit var addTaskButton: Button
    private lateinit var tasksRecyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private val tasks = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskEditText = findViewById(R.id.taskEditText)
        addTaskButton = findViewById(R.id.addTaskButton)
        tasksRecyclerView = findViewById(R.id.tasksRecyclerView)

        taskAdapter = TaskAdapter(tasks)
        tasksRecyclerView.adapter = taskAdapter
        tasksRecyclerView.layoutManager = LinearLayoutManager(this)

        addTaskButton.setOnClickListener {
            val taskDescription = taskEditText.text.toString()
            if (taskDescription.isNotEmpty()) {
                val task = Task(taskDescription)
                tasks.add(task)
                taskAdapter.notifyItemInserted(tasks.size - 1)
                taskEditText.text.clear()
            }
        }
    }
}
