package com.mehmetbaloglu.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun firstScreen(navController: NavController) {
    var name by remember { mutableStateOf("no name") }
    var age by remember { mutableStateOf(0) }
    var isMale by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "This is the First Screen",
            color = Color.Red,
            modifier = Modifier.padding(bottom = 16.dp),
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 32.sp,
        )

        OutlinedTextField(
            value = if (name == "no name") "" else name,
            onValueChange = { name = it },
            label = { Text("Enter your name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
        )

        OutlinedTextField(
            value = if (age == 0) "" else age.toString(),
            onValueChange = { age = it.toIntOrNull() ?: 0 },
            label = { Text("Enter your age") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)

        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(start = 32.dp)
                .fillMaxWidth(),

            ) {
            Text("Female", modifier = Modifier.padding(end = 8.dp))
            Switch(
                checked = isMale, onCheckedChange = { isMale = it }, colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Gray,
                    uncheckedThumbColor = Color.Gray,
                    checkedTrackColor = Color.LightGray,
                    uncheckedTrackColor = Color.LightGray
                )
            )
            Text("Male", modifier = Modifier.padding(start = 8.dp))
        }

        Button(
            onClick = {
                navController.navigate("second_screen/$name/$age/$isMale")
            }, modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "go to second screen")
        }
    }
}