package com.example.proyectoapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectoapp.navigation.AppScreen
import com.example.proyectoapp.R
import kotlinx.coroutines.delay

@Composable
fun FirstScreen(navController: NavController) {
    LoadingScreen(navController)
}


@Composable
fun LoadingScreen(navController: NavController) {


    Column(Modifier
            .fillMaxSize()
            .background(colorResource(R.color.fondo)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Red)){
                    append("Poke")
                }
                withStyle(style = SpanStyle(color = Color.White)){
                    append("App")
                }
            },
            style = TextStyle(
                fontSize = 30.sp,
            ),
            modifier = Modifier.padding(24.dp)
        )

        Image(painterResource(R.drawable.pokeball), "Poke logo")

        Text("Loading assets. . .", Modifier.padding(top = 16.dp), color = Color.White)

        LinearProgressIndicator(
            modifier = Modifier.padding(32.dp),
            color = Color.Red
        )

        LaunchedEffect(Unit) {
            delay(3000)

            navController.navigate(AppScreen.SecondScreen.route)

        }
    }

}


