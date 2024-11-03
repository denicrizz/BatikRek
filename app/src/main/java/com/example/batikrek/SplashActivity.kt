package com.example.batikrek

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview


class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Durasi splash screen (3 detik)
        Handler(Looper.getMainLooper()).postDelayed({
            // Pindah ke tutorial setelah splash selesai
            val intent = Intent(this, TutorialActivity::class.java)
            startActivity(intent)
            finish() // Tutup activity splash agar tidak bisa diakses dengan tombol "back"
        }, 3000) // 3 detik delay

        // Set composable content untuk splash screen
        setContent {
            SplashScreenContent()
        }
    }
}

@Composable
fun SplashScreenContent() {
    // Background gradasi vertikal
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF3E2723),
                        Color(0xFF6D4C41)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo BatikRek
            Image(
                painter = painterResource(id = R.drawable.logo_batikrek),
                contentDescription = "Logo BatikRek",
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Judul aplikasi
            Text(
                text = "Selamat Datang di BatikRek",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Subtitle
            Text(
                text = "Temukan Batik Favoritmu!",
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}
@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun PreviewSplashScreen() {
    SplashScreenContent()
}

