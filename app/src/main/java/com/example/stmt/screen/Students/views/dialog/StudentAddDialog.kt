package com.example.stmt.screen.Students.views.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stmt.data.student.Student
import com.example.stmt.screen.Students.views.GradeChip
import com.example.stmt.viewmodel.AddDialogViewModel
import com.example.stmt.viewmodel.StudentViewModel
import kotlinx.coroutines.launch

private const val TAG = "StudentAddDialog_이현근"

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun StudentAddDialog(onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false // 화면을 꽉 채우기 위해 필요한 경우 추가합니다.
        )
    ) {
        Scaffold(topBar = { DialogTop(onDismiss = onDismiss) }) {

            Column(Modifier.padding(it)) {
                Divider(color = Color.Gray, thickness = 1.dp)
                StudentInfo(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogTop(onDismiss: () -> Unit) {
    val addDialogViewModel: AddDialogViewModel = viewModel()
    val studentViewModel: StudentViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()

    TopAppBar(
        title = {
            Text(
                "학생 정보 등록",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = onDismiss) {
                Icon(
                    imageVector = Icons.Filled.ExitToApp,
                    contentDescription = "Localized description"
                )
            }
        },
        actions = {
            TextButton(onClick = {
                coroutineScope.launch{
                    val newStudent = Student(
                        addDialogViewModel.name.value,
                        addDialogViewModel.tel.value,
                        addDialogViewModel.school.value,
                        addDialogViewModel.grade.value,
                        addDialogViewModel.gradeDetail.value
                    )

                    studentViewModel.addStudent(newStudent)
                    onDismiss()
                }
            }) {
                Text("등록")
            }
        }
    )
}

@Composable
fun GradeChipsAddDialog(modifier: Modifier) {
    var selectedGradeNumber by remember { mutableStateOf(0) }
    var selectedGradeDetailNumber by remember { mutableStateOf(0) }
    val viewModel: AddDialogViewModel = viewModel()

    Column() {
        Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            GradeChip(name = "초등학생", onClick = {
                selectedGradeNumber = 1
                viewModel.setGrade("초등학생")
            }, selected = selectedGradeNumber == 1)
            GradeChip(name = "중학생", onClick = {
                selectedGradeNumber = 2
                viewModel.setGrade("중학생")
            }, selected = selectedGradeNumber == 2)
            GradeChip(name = "고등학생", onClick = {
                selectedGradeNumber = 3
                viewModel.setGrade("고등학생")
            }, selected = selectedGradeNumber == 3)
        }

        Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            GradeChip(name = "1학년", onClick = {
                selectedGradeDetailNumber = 1
                viewModel.setGradeDetail(1)
            }, selected = selectedGradeDetailNumber == 1)
            GradeChip(name = "2학년", onClick = {
                selectedGradeDetailNumber = 2
                viewModel.setGradeDetail(2)
            }, selected = selectedGradeDetailNumber == 2)
            GradeChip(name = "3학년", onClick = {
                selectedGradeDetailNumber = 3
                viewModel.setGradeDetail(3)
            }, selected = selectedGradeDetailNumber == 3)

        }

        // 초등학생인 경우 표시
        if (selectedGradeNumber == 1) {
            Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                GradeChip(name = "4학년", onClick = {
                    selectedGradeDetailNumber = 4
                    viewModel.setGradeDetail(4)
                }, selected = selectedGradeDetailNumber == 4)
                GradeChip(name = "5학년", onClick = {
                    selectedGradeDetailNumber = 5
                    viewModel.setGradeDetail(5)
                }, selected = selectedGradeDetailNumber == 5)
                GradeChip(name = "6학년", onClick = {
                    selectedGradeDetailNumber = 6
                    viewModel.setGradeDetail(6)
                }, selected = selectedGradeDetailNumber == 6)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentInfo(modifier: Modifier) {
    val viewModel: AddDialogViewModel = viewModel()

    var backgroundColor =
        if (viewModel.grade.collectAsState().value == "초등학생") Color.Yellow
        else if (viewModel.grade.collectAsState().value == "중학생") Color.Blue
        else if (viewModel.grade.collectAsState().value == "고등학생") Color.Red
        else Color.White

    Column(modifier) {
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .height(160.dp)
                .width(160.dp)
                .fillMaxWidth()
                .align(CenterHorizontally)
                .background(backgroundColor)
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(8.dp) // 테두리의 둥글기 정도를 설정합니다.
                )
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(12.dp))

        Divider(color = Color.Gray, thickness = 1.dp, modifier = modifier)

        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            modifier = modifier,
            value = viewModel.name.collectAsState().value,
            onValueChange = { viewModel.setName(it) },
            label = { Text("이름") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )
        OutlinedTextField(
            modifier = modifier.padding(top = 4.dp),
            value = viewModel.tel.collectAsState().value,
            onValueChange = { viewModel.setTel(it) },
            label = { Text("전화번호") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            modifier = modifier.padding(top = 4.dp),
            value = viewModel.school.collectAsState().value,
            onValueChange = { viewModel.setSchool(it) },
            label = { Text("학교") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(12.dp))
        Divider(color = Color.Gray, thickness = 1.dp, modifier = modifier)
        Spacer(modifier = Modifier.height(4.dp))
        Row() {
            GradeChipsAddDialog(modifier = modifier)
        }
    }

}

@Preview
@Composable
fun DialogPrev() {
    StudentInfo(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}