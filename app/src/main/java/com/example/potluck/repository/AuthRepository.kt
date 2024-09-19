package com.example.potluck.repository

import com.example.potluck.model.Auth
import com.example.potluck.service.AuthService

class AuthRepository(private val authService: AuthService) {
    fun login(user: Auth): Boolean {
        return authService.login(user)
    }
}