package com.example.stmt.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stmt.screen.Home.HomeScreen
import com.example.stmt.screen.Students.StudentsScreen

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : Screen("home", "Home", Icons.Outlined.Home)
    object Students : Screen("students", "Students", Icons.Outlined.Person)
}

@Composable
fun App() {
    val navController = rememberNavController()
    val navItems = listOf(Screen.Home, Screen.Students)
    
    Scaffold(
        bottomBar = {
            BottomNavigation(
//                backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer
                contentColor = Color.Yellow
            ) {
                // 아이템에서 선택된 것을 체크하기 위한 변수
                val navBackStackEntry = navController.currentBackStackEntry
                val currentRoute = navBackStackEntry?.destination?.route

                navItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Black,
                        icon = { Icon(imageVector = screen.icon, contentDescription = screen.title)},
                        modifier = Modifier.background(androidx.compose.material3.MaterialTheme.colorScheme.primary)
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            NavHost(navController = navController, startDestination = Screen.Home.route) {
                composable(Screen.Home.route) {
                    HomeScreen()
                }
                composable(Screen.Students.route) {
                    StudentsScreen()
                }
            }
        }
    }
}


