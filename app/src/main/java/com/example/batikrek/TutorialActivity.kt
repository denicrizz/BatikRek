@file:OptIn(ExperimentalFoundationApi::class)

package com.example.batikrek

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TutorialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialScreen()
        }
    }
}

@Composable
fun TutorialScreen() {
    val context = LocalContext.current
    val pagerState = rememberPagerState(pageCount = { 3 })


    LaunchedEffect(pagerState.currentPage) {
        while (true) {
            delay(3000)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.animateScrollToPage(nextPage)
        }
    }


    val tutorialItems = listOf(
        TutorialPage(
            title = "Selamat Datang di BatikRek",
            description = "Aplikasi ini membantu Anda menemukan batik favorit Anda.",
            imageRes = R.drawable.tutorial_image_2
        ),
        TutorialPage(
            title = "Temukan Batik",
            description = "Cari dan jelajahi berbagai jenis batik dari Benang Raja.",
            imageRes = R.drawable.tutorial_image_1
        ),
        TutorialPage(
            title = "Tidak Bingung",
            description = "Memudahkan anda memilih batik yang sesuai dengan acara.",
            imageRes = R.drawable.tutorial_image_3
        )
    )

    @Composable
    fun TutorialItem(title: String, description: String, imageRes: Int) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White, // Mengubah warna teks judul menjadi putih
                modifier = Modifier.padding(8.dp)
            )

            Text(
                text = description,
                fontSize = 16.sp,
                color = Color.White, // Mengubah warna teks deskripsi menjadi putih
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp)
            )
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF674636))
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            TutorialItem(
                tutorialItems[page].title,
                tutorialItems[page].description,
                tutorialItems[page].imageRes
            )
        }


        Row(
            Modifier
                .height(50.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .background(color)
                        .size(8.dp)
                )
            }
        }

        Button(
            onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3E2723) // Mengganti warna background button
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Mulai")
        }
    }
}

@Composable
fun TutorialItem(title: String, description: String, imageRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )

        Text(
            text = description,
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
    }
}

data class TutorialPage(
    val title: String,
    val description: String,
    val imageRes: Int
)

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun PreviewTutorialScreen() {
    TutorialScreen()
}
