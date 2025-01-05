package com.example.batikrek.ui.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.batikrek.api.RetrofitClient
import com.example.batikrek.components.LayoutScreen
import com.example.batikrek.data.BatikRequest
import com.example.batikrek.data.BatikResponse
import kotlinx.coroutines.launch


@ExperimentalMaterial3Api
@Composable
fun RecommendationScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf(0) }
    var selectedEvent by remember { mutableStateOf("") }
    var showLoading by remember { mutableStateOf(false) }
    var recommendation by remember { mutableStateOf("") }
    var recommendationList by remember { mutableStateOf<BatikResponse?>(null) }
    val coroutineScope = rememberCoroutineScope()
    val events = listOf("Pernikahan", "Acara Formal", "Pesta", "Casual", "Acara Keluarga")

    LayoutScreen(navController = navController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

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
                    coroutineScope.launch {
                        try {
                            showLoading = true
                            val body = BatikRequest(selectedEvent)
                            val response = RetrofitClient.apiService.getBatikRecommendation(body)
                            Log.e("RecommendationScreen", "Response: $response")
                            recommendationList = response

                            if (recommendationList != null) {
                                recommendation = recommendationList!!.recommended_batik[0].description
                                showLoading = false
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                            showLoading = false
                        }
                    }
//                    recommendation = getRecommendationForEvent(selectedEvent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Dapatkan Rekomendasi")
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Bagian Rekomendasi
            if (showLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = Color(0xFF8B4513)
                )
            }
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