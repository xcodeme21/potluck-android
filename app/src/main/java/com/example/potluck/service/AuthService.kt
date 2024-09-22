package com.example.potluck.service

import com.example.potluck.model.Auth
import com.example.potluck.model.LoginResponse
import com.example.potluck.model.UserOutput
import com.example.potluck.retrofit.AuthApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://webservice.erajaya.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val authApi: AuthApi = retrofit.create(AuthApi::class.java)

    fun login(user: Auth, onResult: (Boolean, String?, UserOutput?) -> Unit) {
        authApi.login(user).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful && response.body()?.success == true) {
                    val userOutput = response.body()?.output
                    onResult(true, null, userOutput)
                } else {
                    onResult(false, response.body()?.message ?: "Login failed.", null)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                onResult(false, t.message, null)
            }
        })
    }
}
