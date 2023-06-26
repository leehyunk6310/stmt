package com.example.stmt.screen.Students.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StudentList(modifier: Modifier) {
    Text("학생 목록", fontSize = 24.sp, modifier = Modifier.padding(horizontal = 16.dp).padding(bottom = 8.dp))
    LazyColumn(modifier = modifier) {
        items(listOf("초등", "중등", "고등")) {grade->
            StudentItem(grade = grade)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}