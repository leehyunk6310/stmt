package com.example.stmt.screen.Students

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stmt.screen.Students.views.GradeChips
import com.example.stmt.screen.Students.views.RegisterBtn
import com.example.stmt.screen.Students.views.SearchBar
import com.example.stmt.screen.Students.views.dialog.StudentAddDialog
import com.example.stmt.screen.Students.views.StudentList

@Composable
fun StudentsScreen() {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { SearchBar()},
        floatingActionButton = { RegisterBtn(onClick = {showDialog = true})},
        floatingActionButtonPosition = FabPosition.End
    ) {
        // 학생 등록 Dialog 출력
        if (showDialog) {
            StudentAddDialog(onDismiss = {showDialog = false})
        }

        Column(modifier = Modifier.padding(it)) {
            GradeChips(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
            StudentList(modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}


@Preview
@Composable
fun StudentsScreenPrev() {
    StudentsScreen()
}
