package com.example.stmt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.stmt.screen.App
import com.example.stmt.ui.theme.StmtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StmtTheme {
                App()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    StmtTheme {
        App()
    }
}




