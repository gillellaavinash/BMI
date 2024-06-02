package com.example.conversions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController

@Composable
fun BmiResult(navController: NavHostController,
              backStackEntry: NavBackStackEntry) {
    val weight = backStackEntry.arguments?.getFloat("weight")
    val height = backStackEntry.arguments?.getFloat("heightIn")
    println("Weight :$weight and height: $height")

    val heightMeters = ((height)?.div(100))
    val bmiValue = weight?.div((heightMeters!! *heightMeters))
    val bmi = String.format("%.2f", bmiValue).toDouble()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Spacer(modifier = Modifier.width(50.dp))
        Spacer(modifier = Modifier.height(150.dp))
        Card(
            modifier = Modifier
                .padding(16.dp)
                .size(200.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                colorResource(id = R.color.teal_200)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 20.dp
            )
        ) {
            Column(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(45.dp))
                when (bmi) {
                    in 0.0..18.5 -> {
                        Text(text = "UnderWeight", fontSize = 30.sp)
                        Text(text = "$bmi", fontSize = 30.sp)
                    }

                    in 18.5..24.9 -> {
                        Text(text = "Normal", fontSize = 30.sp)
                        Text(text = "$bmi", fontSize = 30.sp)
                    }

                    in 25.0..29.9 -> {
                        Text(text = "OverWeight", fontSize = 30.sp)
                        Text(text = "$bmi", fontSize = 30.sp)
                    }

                    in 30.0..100.0 -> {
                        Text(text = "Obese", fontSize = 30.sp)
                        Text(text = "$bmi", fontSize = 30.sp)
                    }
                }
            }
        }
    }
}

