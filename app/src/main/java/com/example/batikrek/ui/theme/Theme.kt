package com.example.batikrek.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Warna tema terang
private val LightColors = lightColorScheme(
    primary = Color(0xFF8B4513),
    secondary = Color(0xFFD4A24F),
    background = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
)

// Warna tema gelap
private val DarkColors = darkColorScheme(
    primary = Color(0xFF8B4513),
    secondary = Color(0xFFD4A24F),
    background = Color.Black,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
)

// Fungsi tema utama untuk mengatur tampilan sesuai dengan preferensi tema (gelap atau terang)
@Composable
fun BatikrekTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography, // Atur tipografi sesuai keinginan
        content = content
    )
}
