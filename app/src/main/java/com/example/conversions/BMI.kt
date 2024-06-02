package com.example.conversions

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.conversions.ui.theme.ConversionsTheme

@Composable
fun BMI(navController: NavHostController) {
    val context = LocalContext.current
    var weight by remember {
        mutableStateOf("0")
    }
    var heightIn by remember {
        mutableStateOf("0")
    }
    var sliderPosition1 by remember { mutableFloatStateOf(0f) }
    var sliderPosition2 by remember { mutableFloatStateOf(0f) }
    val color = colorResource(id = R.color.blue)
    val buttonColor = colorResource(id = R.color.ash)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(id = R.color.pink)
            ),
        verticalArrangement = Arrangement.spacedBy(75.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.width(36.dp))
            //Spacer(modifier = Modifier.height(706.dp))
            Card(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(200.dp)
                    .padding(16.dp),
                shape = ShapeDefaults.Small,
                colors = CardDefaults.cardColors(
                    containerColor = color
                ),
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 5.dp
                ),
            ) {
                Spacer(modifier = Modifier.height(46.dp))
                Text(text = "Select your weight")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Weight: $weight kg")
            }

            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Slider(
                    value = sliderPosition1,
                    onValueChange = { sliderPosition1 = it },
                    valueRange = 0f..150f
                )
                Text(text = sliderPosition1.toString())
                weight = String.format("%.2f", sliderPosition1).toDouble().toString()
            }

        }

        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.width(36.dp))
            //Spacer(modifier = Modifier.height(706.dp))
            Card(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(200.dp)
                    .padding(16.dp),
                shape = ShapeDefaults.Small,
                colors = CardDefaults.cardColors(
                    containerColor = color
                ),
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 5.dp
                ),
            ) {
                Spacer(modifier = Modifier.height(46.dp))
                Text(text = "Select your height")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Weight: $heightIn cm")
            }

            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Slider(
                    value = sliderPosition2,
                    onValueChange = { sliderPosition2 = it },
                    valueRange = 100f..200f
                )
                Text(text = sliderPosition2.toString())
                heightIn = String.format("%.2f", sliderPosition2).toDouble().toString()
            }
        }
        Button(onClick = {
            if(weight == "0.0" || heightIn == "100.0" || heightIn == "0.0") {
                Toast.makeText(context , "Please enter weight and height",Toast.LENGTH_SHORT).show()
            }else{
                println("weight: $weight, height: $heightIn")
                navController.navigate("result/${weight}/${heightIn}")
            }
        },
            modifier = Modifier.padding(10.dp),
            shape = ShapeDefaults.Small,
            colors = ButtonDefaults.buttonColors(
                buttonColor
            )
        ) {
            Text("CALCULATE", style = TextStyle(
                color = Color.Black
            ))
        }
    }
}

