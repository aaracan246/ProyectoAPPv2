package com.example.proyectoapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectoapp.navigation.AppScreen
import com.example.proyectoapp.R


@Composable
fun Footer(navController: NavController) {
    NavigationBarFun(navController)
}

@Composable
fun NavigationBarFun(navController: NavController) {
    BottomNavigation(
        backgroundColor = colorResource(R.color.white),
        contentColor = Color.White
    ){
        BottomNavigationItem(
            selected = false,
            onClick = {
                navController.navigate(AppScreen.ThirdScreen.route)
            },
            icon = {
                Image(painter = painterResource(R.drawable.pokeusericontrue), "User Options", Modifier.size(40.dp))
            },
            modifier = Modifier.background(color = colorResource(R.color.white))
        )

        Spacer(Modifier.padding(horizontal = 3.dp))

        BottomNavigationItem(
            selected = false,
            onClick = {
                navController.navigate(route = AppScreen.FourthScreen.route)
            },
            icon = {
                Image(painter = painterResource(R.drawable.superballicon), "Pokémon", Modifier.size(40.dp))
            },
            modifier = Modifier.background(color = colorResource(R.color.white))
        )

        Spacer(Modifier.padding(horizontal = 3.dp))

        BottomNavigationItem(
            selected = false,
            onClick = {
                navController.navigate(AppScreen.FourthScreen.route)
            },
            icon = {
                Image(painter = painterResource(R.drawable.hyperballicon), "Tabla de tipos", Modifier.size(40.dp))
            },
            modifier = Modifier.background(color = colorResource(R.color.white))
        )

        Spacer(Modifier.padding(horizontal = 3.dp))

        BottomNavigationItem(
            selected = false,
            onClick = {
                navController.navigate(route = AppScreen.FourthScreen.route)
            },
            icon = {
                Image(painter = painterResource(R.drawable.adminicon), "Admin", Modifier.size(40.dp))
            },
            modifier = Modifier.background(color = colorResource(R.color.white))
        )
    }
}
