package com.example.batikrek.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class bottomBar(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object Beranda : bottomBar("beranda", "Beranda", Icons.Default.Home)
    data object Katalog : bottomBar("katalog", "katalog", Icons.AutoMirrored.Default.List)
    data object Rekomendasi : bottomBar("rekomendasi", "rekomendasi", Icons.Default.ThumbUp)
    data object Profil : bottomBar("profil", "profil", Icons.Default.Person)
}

val BottomBarData = listOf(
    bottomBar.Beranda,
    bottomBar.Katalog,
    bottomBar.Rekomendasi,
    bottomBar.Profil
)