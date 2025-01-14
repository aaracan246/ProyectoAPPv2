package com.example.proyectoapp.viewmodel

import androidx.datastore.dataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectoapp.datastore.DataStoreManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(private val dataStoreManager: DataStoreManager): ViewModel() {


    init {
        viewModelScope.launch {

            dataStoreManager.getUserName().collect{ savedUsername ->
                _username.value = savedUsername.orEmpty()
                _isChecked.value = savedUsername.isNullOrEmpty()
            }
        }

        viewModelScope.launch {
            dataStoreManager.getUserPassword().collect{ savedPassword ->
                _password.value = savedPassword.orEmpty()
            }
        }
    }
    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username
    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _loadingBar = MutableStateFlow(false)
    val loadingBar: StateFlow<Boolean> = _loadingBar

    private val _isChecked = MutableStateFlow(false)
    val isChecked: StateFlow<Boolean> = _isChecked

    private val _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean> = _isError

    fun usernameUpdate(newUser: String){
        _username.update { newUser }
    }

    fun passwordUpdate(newPassword: String){
        _password.update { newPassword }
    }

//    private val _checkRememberUsername = MutableStateFlow(false)
//    val checkRememberUsername: StateFlow<Boolean> = _checkRememberUsername
//
//    private val _checkRememberPass = MutableStateFlow(false)
//    val checkRememberPass: StateFlow<Boolean> = _checkRememberPass

    fun checkRememberMe(){
        _isChecked.value = !_isChecked.value
    }

    fun changeErrorValue(state: Boolean){
        _isError.value = state
    }

    fun saveLogCredentials(){
        viewModelScope.launch {
            if (_isChecked.value){ dataStoreManager.saveUserData(_username.value, _password.value) }
            else { dataStoreManager.saveUserData("", "") }
        }
    }

    fun resetCredentials() {
        usernameUpdate("")
        passwordUpdate("")
    }
}
