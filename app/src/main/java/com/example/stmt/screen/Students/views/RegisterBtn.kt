package com.example.stmt.screen.Students.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RegisterBtn(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        icon = { Icon(Icons.Filled.Add, "Localized description") },
        text = { Text(text = "등록") },
    )
}

@Composable
@Preview
fun RegisterBtnPrev() {
//    RegisterBtn()
}