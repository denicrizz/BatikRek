package com.example.batikrek.components


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.batikrek.data.BottomBarData


@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = Color(0xFF8B4513), // Background warna gelap
        tonalElevation = 8.dp
    ) {
        BottomBarData.forEach { item ->
            val selected = currentRoute == item.route
//            val icon = remember(selected) {
//                if (selected) item.selectedIcon else item.unselectedIcon
//            }

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(text = item.title) },
                selected = selected,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black, // Warna hitam untuk ikon tab yang dipilih
                    unselectedIconColor = Color.Black, // Warna abu-abu untuk ikon tab yang tidak dipilih
                    selectedTextColor = Color.White, // Warna hitam untuk teks tab yang dipilih
                    unselectedTextColor = Color.White // Warna abu-abu untuk teks tab yang tidak dipilih
                )
            )
        }
    }
}