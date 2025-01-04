package com.example.batikrek.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.batikrek.data.Batik

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
