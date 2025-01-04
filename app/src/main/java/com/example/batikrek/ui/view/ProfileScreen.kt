package com.example.batikrek.ui.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.batikrek.components.LayoutScreen

@Composable
fun ProfileScreen(navController: NavController) {
    LayoutScreen(navController = navController) {
        Text(text = "Halaman Profil")
    }
}