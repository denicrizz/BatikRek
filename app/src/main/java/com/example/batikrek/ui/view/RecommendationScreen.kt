package com.example.batikrek.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.batikrek.components.LayoutScreen
import com.example.batikrek.getRecommendationForEvent

@ExperimentalMaterial3Api
@Composable
fun RecommendationScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf(0) }
    var selectedEvent by remember { mutableStateOf("") }
    var recommendation by remember { mutableStateOf("") }
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