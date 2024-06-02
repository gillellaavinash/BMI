package com.example.conversions.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.conversions.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        LaunchedEffect(key1 = Unit) {
            delay(1000L) // Delay for 3 seconds
            navController.navigate("bmi")
            {
                launchSingleTop = true
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = false
                }
            }
        }

        Image(
            painter = painterResource(id = R.drawable.bmi_image),
            contentDescription = "Splash Screen Image",
            alignment = Alignment.Center,
            //modifier = Modifier.fillMaxSize()
        )
    }
}