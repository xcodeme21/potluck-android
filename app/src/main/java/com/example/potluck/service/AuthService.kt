package com.example.potluck.service

import com.example.potluck.model.Auth

class AuthService {
    fun login(user: Auth): Boolean {
        return user.email == "agus.siswanto@erajaya.com" && user.password == "password123"
    }
}