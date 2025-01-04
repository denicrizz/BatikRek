package com.example.batikrek.route

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.batikrek.ui.view.HomeScreen
import com.example.batikrek.ui.view.KatalogScreen
import com.example.batikrek.ui.view.ProfileScreen
import com.example.batikrek.ui.view.RecommendationScreen

@ExperimentalMaterial3Api
@Composable
fun NavRoute(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "beranda") {
        composable("beranda") {
            HomeScreen(navController)
        }
        composable("katalog") {
            KatalogScreen(navController)
        }
        composable("rekomendasi") {
            RecommendationScreen(navController)
        }
        composable("profil") {
            ProfileScreen(navController)
        }
    }
}