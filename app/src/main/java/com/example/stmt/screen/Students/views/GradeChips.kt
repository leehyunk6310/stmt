package com.example.stmt.screen.Students.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.G
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GradeChip(name: String, onClick: () -> Unit, selected: Boolean) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = { Text(name) },
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Localized Description",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}

@Composable
fun GradeChips(modifier: Modifier) {
    var selectedChipNumber by remember { mutableStateOf(0) }

    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        GradeChip(name = "전체", onClick = {
            selectedChipNumber = 1
        }, selected = selectedChipNumber  == 1)
        GradeChip(name = "초등학생", onClick = {
            selectedChipNumber = 2
        }, selected = selectedChipNumber  == 2)
        GradeChip(name = "중학생", onClick = {
            selectedChipNumber = 3
        }, selected = selectedChipNumber  == 3)
        GradeChip(name = "고등학생", onClick = {
            selectedChipNumber = 4
        }, selected = selectedChipNumber  == 4)
    }
}


@Preview
@Composable
fun GradeChipsPreview() {
//    GradeChips(Modifier.padding(vertical = 8.dp))
//    GradeChipsAddDialog(modifier = Modifier.padding(vertical = 8.dp))
}