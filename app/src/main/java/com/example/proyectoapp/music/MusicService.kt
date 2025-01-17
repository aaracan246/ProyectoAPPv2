package com.example.proyectoapp.music

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import com.example.proyectoapp.R

class  MusicService: Service() {
    private lateinit var mediaPlayer: MediaPlayer
    private val binder = MusicBinder()

    override fun onCreate() {
        super.onCreate()

        mediaPlayer = MediaPlayer.create(this, R.raw.little_root_town_theme)
        mediaPlayer.isLooping = true // Bucle
        mediaPlayer.setVolume(1.0f, 1.0f)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer.start() // Comienza el servicio
        return START_STICKY // Mantiene el servicio
    }

    fun isMusicPlaying(): Boolean{
        return mediaPlayer.isPlaying
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    inner class MusicBinder: Binder(){
        fun getService(): MusicService = this@MusicService
    }
}