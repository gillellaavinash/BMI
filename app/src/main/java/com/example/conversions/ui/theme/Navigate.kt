package com.example.conversions.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.conversions.BMI
import com.example.conversions.BmiResult

@Composable
fun Navigate(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash"){
        composable("splash"){
            SplashScreen(
                navController = navController
            )
        }
        composable("bmi"){
            BMI(
                navController = navController
            )
        }
        composable("result/{weight}/{heightIn}",
            arguments = listOf(
                navArgument("weight"){
                    type = NavType.FloatType
                },
                navArgument("heightIn"){
                    type = NavType.FloatType
                }
            )
        ) { backStackEntry ->
            BmiResult(
                navController = navController,
                backStackEntry = backStackEntry
            )
        }
    }
}