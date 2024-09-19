package com.example.potluck.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.potluck.model.Auth
import com.example.potluck.repository.AuthRepository
import com.example.potluck.service.AuthService

class LoginViewModel : ViewModel() {
    private val authRepository = AuthRepository(AuthService())

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var isLoggedIn by mutableStateOf(false)
    var errorMessage by mutableStateOf("")

    fun onLoginClick() {
        val user = Auth(email, password)
        if (authRepository.login(user)) {
            isLoggedIn = true
        } else {
            errorMessage = "Invalid credentials"
        }
    }

    fun isFormValid() = email.isNotEmpty() && password.isNotEmpty()
}