package com.example.potluck.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.potluck.model.Auth
import com.example.potluck.model.UserOutput
import com.example.potluck.repository.AuthRepository
import com.example.potluck.service.AuthService

class LoginViewModel : ViewModel() {
    private val authRepository = AuthRepository(AuthService())

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var isLoggedIn by mutableStateOf(false)
    var errorMessage by mutableStateOf("")
    var userOutput by mutableStateOf<UserOutput?>(null)

    fun onLoginClick() {
        val user = Auth(email, password)
        authRepository.login(user) { success, message, output ->
            if (success) {
                isLoggedIn = true
                errorMessage = ""
                userOutput = output
            } else {
                errorMessage = message ?: "Invalid credentials"
            }
        }
    }

    fun isFormValid() = email.isNotEmpty() && password.isNotEmpty()
}