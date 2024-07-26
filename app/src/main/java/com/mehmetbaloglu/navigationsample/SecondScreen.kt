package com.mehmetbaloglu.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun secondScreen(name:String, age:Int, isMale:Boolean, navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "This is the Second Screen",
            color = Color.Red,
            modifier = Modifier.padding(16.dp),
            fontSize = 32.sp,
        )

        var gender : String = if (isMale) "Male" else "Female"
        Row (horizontalArrangement = Arrangement.Center){
            Text(text ="Welcome ")
            Text(text ="$name", color = Color.Blue)
        }
        Row (horizontalArrangement = Arrangement.Center){
            Text(text ="Your age is ")
            Text(text ="$age", color = Color.Blue)
        }
        Row (horizontalArrangement = Arrangement.Center){
            Text(text ="You are ")
            Text(text ="$gender", color = Color.Blue)
        }

        Button(
            onClick = { navController.navigate("third_screen") },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "go to third screen")
        }


    }

}