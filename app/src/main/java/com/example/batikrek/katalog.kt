package com.example.batikrek.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.batikrek.BottomNavigationBar
import com.example.batikrek.BatikItem
import com.example.batikrek.R
import com.example.batikrek.data.Batik.Companion.batikData
import com.example.batikrek.ui.theme.BatikrekTheme

@Composable
fun KatalogScreen(innerPadding: PaddingValues, selectedTab: Int, onTabSelected: (Int) -> Unit) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(selectedTab = selectedTab, onTabSelected = onTabSelected)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // nama dan ikon aplikasi
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_batikrek),
                    contentDescription = "App Icon",
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = "BatikRek",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Katalog Lengkap",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Adaptive(150.dp),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(batikData) { batik ->
                    BatikItem(batik = batik)
                }
            }
        }
    }
}


@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun PreviewKatalog() {
    BatikrekTheme {
        KatalogScreen(
            innerPadding = PaddingValues(0.dp),
            selectedTab = 1,
            onTabSelected = {}
        )
    }
}
