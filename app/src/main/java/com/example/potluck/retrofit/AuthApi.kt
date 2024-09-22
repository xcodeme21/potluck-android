package com.example.potluck.retrofit

import com.example.potluck.model.Auth
import com.example.potluck.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApi {
    @Headers("Content-Type: application/json")
    @POST("ldap_server/api/login")
    fun login(@Body user: Auth): Call<LoginResponse>
}