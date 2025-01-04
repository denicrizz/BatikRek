@file:OptIn(ExperimentalFoundationApi::class)
package com.example.batikrek

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.batikrek.data.Batik
import com.example.batikrek.data.Batik.Companion.batikData
import com.example.batikrek.route.NavRoute
import com.example.batikrek.ui.theme.BatikrekTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BatikrekTheme(darkTheme = false) {
                val navController = rememberNavController()
                NavRoute(navController = navController)
//                MainScreen()
            }
        }
    }
}


@Composable
fun BatikCatalog(batikList: List<Batik>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Batik Populer",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {
            items(batikList) { batik ->
                BatikItem(batik = batik)
            }
        }
    }
}

@Composable
fun BatikItem(batik: Batik) {
    Card(
        modifier = Modifier
            .width(150.dp) // Atur lebar tetap
            .height(250.dp) // Atur tinggi tetap untuk memastikan semua card memiliki tinggi yang sama
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F4F4))
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween // Atur agar elemen tersebar secara vertikal
        ) {
            // Gambar batik
            Image(
                painter = painterResource(id = batik.imageRes),
                contentDescription = batik.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(bottom = 8.dp)
            )
            // Nama Batik
            Text(
                text = batik.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black
            )
            // Motif Batik
            Text(
                text = batik.motif,
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            // Spacer agar jarak tetap terjaga
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Cocok untuk: ${batik.suitableFor}",
                fontSize = 12.sp,
                color = Color(0xFFB3541E), // Warna oranye untuk kategori penggunaan
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}



// prototype fungsi rekomendasi
fun getRecommendationForEvent(event: String): String {
    return when (event) {
        "Pernikahan" -> "Untuk acara pernikahan, kami merekomendasikan batik dengan motif klasik seperti Sidoasih atau Sidomukti yang melambangkan kebahagiaan dan kemakmuran."
        "Acara Formal" -> "Untuk acara formal, batik dengan motif geometris atau Kawung sangat cocok. Pilih warna yang tidak terlalu mencolok."
        "Pesta" -> "Untuk pesta, Anda bisa memilih batik dengan motif modern dan warna-warna cerah. Motif Mega Mendung atau Parang bisa menjadi pilihan yang bagus."
        "Casual" -> "Untuk acara casual, batik kontemporer dengan motif sederhana dan warna-warna natural sangat cocok. Motif Truntum atau Sekar Jagad bisa menjadi pilihan."
        "Acara Keluarga" -> "Untuk acara keluarga, batik dengan motif tradisional seperti Sogan atau Ceplok sangat pas. Pilih warna yang hangat dan nyaman."
        else -> "Silakan pilih jenis acara terlebih dahulu untuk mendapatkan rekomendasi."
    }
}


//@Preview(showBackground = true, device = "id:pixel_5")
//@Composable
//fun PreviewMainActivity() {
//    BatikrekTheme {
//        MainScreen()
//    }
//}
