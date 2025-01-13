package com.example.phasmoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.proyectoapp.navigation.AppScreen
import com.example.proyectoapp.screen.FirstScreen
import com.example.proyectoapp.screen.SecondScreen
import com.example.proyectoapp.screen.ThirdScreen
import com.example.proyectoapp.screen.FourthScreen
import com.example.proyectoapp.viewmodel.AppViewModel

@Composable
fun AppNavigation(navController: NavHostController, appViewModel: AppViewModel){

    NavHost(navController = navController, startDestination = AppScreen.FirstScreen.route){

        composable(AppScreen.FirstScreen.route){ FirstScreen(navController) }

        composable(AppScreen.SecondScreen.route){ SecondScreen(navController, appViewModel) }

        composable(AppScreen.ThirdScreen.route) { ThirdScreen(navController) }

        composable(AppScreen.FourthScreen.route) { FourthScreen(navController) }

    }
}