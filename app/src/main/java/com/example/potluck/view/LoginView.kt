package com.example.potluck.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.potluck.R
import com.example.potluck.ui.components.CustomButton
import com.example.potluck.ui.components.ButtonStyle
import com.example.potluck.viewmodel.LoginViewModel

@Composable
fun LoginView(modifier: Modifier = Modifier, viewModel: LoginViewModel = remember { LoginViewModel() }) {
    val isFormValid = viewModel.isFormValid()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        )

        Spacer(modifier = Modifier.height(42.dp))

        TextField(
            value = viewModel.email,
            onValueChange = {
                viewModel.email = it
                Log.d("LoginView", "Email changed: $it")
            },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = viewModel.password,
            onValueChange = {
                viewModel.password = it
                Log.d("LoginView", "password changed: $it")
            },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        CustomButton(
            onClick = { viewModel.onLoginClick() },
            style = if (isFormValid) ButtonStyle.Primary else ButtonStyle.Default,
            text = "Login"
        )

        if (viewModel.isLoggedIn) {
            Text("Login Successful!")
        } else if (viewModel.errorMessage.isNotEmpty()) {
            Text("Error: ${viewModel.errorMessage}")
        }
    }
}