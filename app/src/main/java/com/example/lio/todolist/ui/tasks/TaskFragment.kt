package com.example.lio.todolist.ui.tasks

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lio.todolist.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskFragment: Fragment(R.layout.fragment_tasks) {

    private val viewModel: TasksViewModel by viewModels()
}