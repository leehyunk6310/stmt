package com.example.stmt.screen.Students.views

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stmt.viewmodel.StudentViewModel

private const val TAG = "StudentList_이현근"
@Composable
fun StudentList(modifier: Modifier) {
    val studentViewModel:StudentViewModel = viewModel()
    val students by studentViewModel.students.collectAsState()

    LaunchedEffect(Unit) {
        studentViewModel.getAllStudents()
    }

    Text("학생 목록", fontSize = 24.sp, modifier = Modifier
        .padding(horizontal = 16.dp)
        .padding(bottom = 8.dp))
    LazyColumn(modifier = modifier) {
        items(students) {student->
            StudentItem(student)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}