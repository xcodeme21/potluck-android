package com.example.potluck.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.potluck.model.Auth
import com.example.potluck.repository.AuthRepository
import com.example.potluck.service.AuthService

class LoginViewModel : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    var isLoggedIn by mutableStateOf(false)
    var errorMessage by mutableStateOf("")

    fun isFormValid(): Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }

    fun onLoginClick() {
        if (email == "test@example.com" && password == "password") {
            isLoggedIn = true
            errorMessage = ""
        } else {
            errorMessage = "Invalid credentials"
        }
    }
}