package com.example.batikrek.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.batikrek.R

@ExperimentalMaterial3Api
@Composable
fun LayoutScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    topBar: @Composable () -> Unit = {
        TopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
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
            },

        )
    },
    bottomBar: @Composable () -> Unit = { BottomNavigationBar(navController = navController)},
    contentScreen: @Composable () -> Unit
) {
    Scaffold(
        topBar = topBar,
        bottomBar = bottomBar,
        modifier = modifier
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
//            .fillMaxSize()
        ) {
            contentScreen()
        }
    }
}