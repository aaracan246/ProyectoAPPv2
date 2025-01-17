package com.example.proyectoapp

import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ServiceTestRule
import com.example.proyectoapp.music.MusicService
import junit.framework.TestCase.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeoutException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class TestsPokeApp {

    @get:Rule
    val serviceTestRule = ServiceTestRule() // Para el servicio
    val composeTestRule = createComposeRule() // Para los componentes

    @Test
    @Throws(TimeoutException::class)
    fun test_MusicServiceStarts() {

        val serviceIntent = Intent(
            ApplicationProvider.getApplicationContext<Context>(),
            MusicService::class.java)

        val binder: IBinder = serviceTestRule.bindService(serviceIntent)

        val service: MusicService = (binder as MusicService.MusicBinder).getService()

        assertTrue("El servicio debería estar funcionando.", service.isMusicPlaying())
    }

}