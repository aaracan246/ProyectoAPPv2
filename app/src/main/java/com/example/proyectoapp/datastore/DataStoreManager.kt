package com.example.proyectoapp.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit

import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class DataStoreManager(private val context: Context){

    companion object{
        val USER_NAME_KEY = stringPreferencesKey("user_name")
        val USER_PASSWORD_KEY = stringPreferencesKey("user_password")
    }


    // SAVE
    suspend fun saveUserData(context: Context, name: String, password: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME_KEY] = name
            preferences[USER_PASSWORD_KEY] = password
        }
    }

    // LOAD
    fun getUserName(context: Context): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[USER_NAME_KEY]
        }
    }

    fun getUserPassword(context: Context): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[USER_PASSWORD_KEY]
        }
    }
}