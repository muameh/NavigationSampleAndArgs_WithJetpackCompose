package com.mehmetbaloglu.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mehmetbaloglu.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    myApp()
                }
            }
        }
    }
}

@Composable
fun myApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "first_screen") {

        composable("first_screen") {
            firstScreen(navController)
        }

        composable("second_screen/{name}/{age}/{gender}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("age") { type = NavType.IntType },
                navArgument("gender") { type = NavType.BoolType }
            )
        ) { it ->
            val name = it.arguments?.getString("name") ?: "no name"
            val age = it.arguments?.getInt("age") ?: 0
            val gender = it.arguments?.getBoolean("gender") ?: true

            secondScreen(name = name, age = age, isMale = gender, navController)
        }

        composable("third_screen"){
            thirdScreen(navController)
        }




    }
}



