package com.example.potluck.model

data class Auth(
    val email: String,
    val password: String
)

data class LoginResponse(
    val success: Boolean,
    val LDAP_Setting: Boolean,
    val output: UserOutput,
    val message: String
)

data class UserOutput(
    val email: String,
    val username: String,
    val name: String,
    val group: String?,
    val title: String,
    val mailserver: List<String>,
    val your_ip: String
)