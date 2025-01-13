package com.example.proyectoapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.proyectoapp.R

@Composable
fun Header(){



    Row(
    modifier = Modifier.padding(26.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center) {

        Image(painter = painterResource(R.drawable.pokeball), contentDescription = "Imagen del icono de PokeApp", Modifier.size(120.dp))
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
    }
}
