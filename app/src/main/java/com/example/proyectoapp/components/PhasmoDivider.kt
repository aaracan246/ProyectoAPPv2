package com.example.proyectoapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proyectoapp.R

@Composable
fun PhasmoDivider(){
    Row(verticalAlignment = Alignment.CenterVertically) {
        HorizontalDivider(modifier = Modifier
            .weight(1f)
            .padding(start = 16.dp, end = 8.dp))

        Image(
            painter = painterResource(R.drawable.pokeballicontrue),
            contentDescription = "Decoración con icono",
            modifier = Modifier
                .size(36.dp),
            alignment = Alignment.Center)

        HorizontalDivider(modifier = Modifier
            .weight(1f)
            .padding(start = 8.dp, end = 16.dp))
    }
}