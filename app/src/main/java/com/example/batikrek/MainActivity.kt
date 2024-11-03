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
import com.example.batikrek.data.Batik
import com.example.batikrek.data.Batik.Companion.batikData
import com.example.batikrek.ui.theme.BatikrekTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BatikrekTheme {
                MainScreen()
            }
        }
    }
}
@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    var selectedEvent by remember { mutableStateOf("") }
    var recommendation by remember { mutableStateOf("") }
    val events = listOf("Pernikahan", "Acara Formal", "Pesta", "Casual", "Acara Keluarga")

    Scaffold(
        bottomBar = {
            BottomNavigationBar(selectedTab) { selectedTab = it }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Header dengan ikon dan judul
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_batikrek),
                    contentDescription = "App Icon",
                    modifier = Modifier
                        .size(70.dp)
                )
                Text(
                    text = "BatikRek",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Bagian katalog batik
            BatikCatalog(batikData)

            Spacer(modifier = Modifier.height(32.dp))

            // Pilihan Event atau Acara
            Text(text = "Pilih Jenis Acara", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))

            var expanded by remember { mutableStateOf(false) }

            Box {
                OutlinedButton(onClick = { expanded = !expanded }) {
                    Text(text = if (selectedEvent.isNotEmpty()) selectedEvent else "Pilih Acara")
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    events.forEach { event ->
                        DropdownMenuItem(
                            text = { Text(text = event) },
                            onClick = {
                                selectedEvent = event
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Tombol Rekomendasi
            Button(
                onClick = {
                    recommendation = getRecommendationForEvent(selectedEvent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Dapatkan Rekomendasi")
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Bagian Rekomendasi
            if (recommendation.isNotEmpty()) {
                Text(
                    text = "Rekomendasi Pakaian Batik untuk $selectedEvent:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = recommendation, fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    NavigationBar(
        containerColor = Color(0xFF8B4513), // Background warna gelap
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Beranda",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Beranda") },
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black, // Warna hitam untuk ikon tab yang dipilih
                unselectedIconColor = Color.Black, // Warna abu-abu untuk ikon tab yang tidak dipilih
                selectedTextColor = Color.White, // Warna hitam untuk teks tab yang dipilih
                unselectedTextColor = Color.White // Warna abu-abu untuk teks tab yang tidak dipilih
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.List,
                    contentDescription = "Katalog",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("katalog") },
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black, // Warna hitam untuk ikon tab yang dipilih
                unselectedIconColor = Color.Black, // Warna abu-abu untuk ikon tab yang tidak dipilih
                selectedTextColor = Color.White, // Warna hitam untuk teks tab yang dipilih
                unselectedTextColor = Color.White // Warna abu-abu untuk teks tab yang tidak dipilih
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.ThumbUp,
                    contentDescription = "Rekomendasi",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Rekomendasi") },
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black, // Warna hitam untuk ikon tab yang dipilih
                unselectedIconColor = Color.Black, // Warna abu-abu untuk ikon tab yang tidak dipilih
                selectedTextColor = Color.White, // Warna hitam untuk teks tab yang dipilih
                unselectedTextColor = Color.White // Warna abu-abu untuk teks tab yang tidak dipilih
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Profil",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Profil") },
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black, // Warna hitam untuk ikon tab yang dipilih
                unselectedIconColor = Color.Black, // Warna abu-abu untuk ikon tab yang tidak dipilih
                selectedTextColor = Color.White, // Warna hitam untuk teks tab yang dipilih
                unselectedTextColor = Color.White // Warna abu-abu untuk teks tab yang tidak dipilih
            )
        )

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
            // Kategori Penggunaan dengan warna oranye
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


@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun PreviewMainActivity() {
    BatikrekTheme {
        MainScreen()
    }
}
