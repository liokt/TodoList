package com.example.lio.todolist.ui.tasks

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.lio.todolist.data.TaskDao


class TasksViewModel @ViewModelInject constructor(
    private val taskDao: TaskDao
): ViewModel() {
}