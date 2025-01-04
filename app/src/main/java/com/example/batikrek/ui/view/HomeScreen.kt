package com.example.batikrek.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.batikrek.BatikCatalog
import com.example.batikrek.data.Batik.Companion.batikData
import com.example.batikrek.R
import com.example.batikrek.components.LayoutScreen
import com.example.batikrek.getRecommendationForEvent

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navController: NavController) {
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
            verticalArrangement = Arrangement.Top
        ) {


            // Bagian katalog batik
            BatikCatalog(batikData)

            Spacer(modifier = Modifier.height(32.dp))

        }
    }
}