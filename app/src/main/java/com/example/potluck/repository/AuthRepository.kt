package com.example.potluck.repository

import com.example.potluck.model.Auth
import com.example.potluck.model.UserOutput
import com.example.potluck.service.AuthService

class AuthRepository(private val authService: AuthService) {
    fun login(user: Auth, onResult: (Boolean, String?, UserOutput?) -> Unit) {
        authService.login(user, onResult)
    }
}