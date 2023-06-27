package com.example.stmt.screen.Students.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stmt.data.Student

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentItem(student: Student) {
    val color =
        if (student.grade == "초등학생") Color.Yellow else if (student.grade == "중학생") Color.Blue else if (student.grade == "고등학생") Color.Red else Color.White

    Card(
        onClick = { /* Do something */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        Box(
            Modifier
                .fillMaxSize(),
        ) {
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        Modifier
                            .width(24.dp)
                            .height(24.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(color = color)
                    )
                    Text(
                        student.studentName,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
                Text(
                    student.school, fontSize = 12.sp, modifier = Modifier
                        .padding(bottom = 4.dp, end = 16.dp)
                        .align(Bottom)
                        .weight(1f)
                        ,
                    textAlign = TextAlign.Right
                )
                Icon(imageVector = Icons.Default.Cancel, contentDescription = "delete")

            }
        }
    }
}

@Preview
@Composable
fun StudentItemPrev() {
    Column() {
        StudentItem(
            Student(
                studentName = "김감자",
                tel = "",
                school = "감자중학교",
                grade = "중학생",
                gradeDetail = 6
            )
        )
        StudentItem(
            Student(
                studentName = "김고구",
                tel = "",
                school = "고구마고등학교",
                grade = "고등학생",
                gradeDetail = 6
            )
        )
        StudentItem(
            Student(
                studentName = "김감자",
                tel = "",
                school = "감자중학교",
                grade = "중학생",
                gradeDetail = 6
            )
        )
        StudentItem(
            Student(
                studentName = "김감자",
                tel = "",
                school = "감자중학교",
                grade = "중학생",
                gradeDetail = 6
            )
        )
    }

}