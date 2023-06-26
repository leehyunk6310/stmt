package com.example.stmt.screen.Students.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentItem(grade: String) {
    val color = if (grade == "초등") Color.Yellow else if (grade == "중등") Color.Blue else Color.Red

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
                Modifier.fillMaxSize().padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        Modifier
                            .width(24.dp)
                            .height(24.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(color = color)
                            )
                    Text("이름", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(start = 16.dp))
                }
                Text("학교", fontSize = 12.sp, modifier = Modifier.padding(start = 12.dp, bottom = 4.dp).align(Bottom))
                Icon(imageVector = Icons.Default.Cancel, contentDescription = "delete")

            }
        }
    }
}

@Preview
@Composable
fun StudentItemPrev() {
    StudentItem("초등")
}