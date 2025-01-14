package com.example.proyectoapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.phasmoapp.navigation.AppNavigation
import com.example.phasmoapp.ui.theme.PokeAppTheme
import com.example.proyectoapp.datastore.DataStoreManager
import com.example.proyectoapp.music.MusicService
import com.example.proyectoapp.viewmodel.AppViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokeAppTheme {

                val dataStoreManager = DataStoreManager(applicationContext)
                val navController = rememberNavController()
                val appViewModel = AppViewModel(dataStoreManager)
                AppNavigation(navController, appViewModel)




            }
        }
        val musicService = Intent(this, MusicService::class.java)
        startService(musicService)
    }

    override fun onDestroy() {
        super.onDestroy()

        val intent = Intent(this, MusicService::class.java)
        stopService(intent)
    }
}


