package com.mehmetbaloglu.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun thirdScreen(navController: NavController) {

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "This is 3.Screen")

        Button(
            onClick = {  navController.navigate("second_screen/ali/100/true") },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "go to second screen with hardcoded deep link")
        }
    }
}