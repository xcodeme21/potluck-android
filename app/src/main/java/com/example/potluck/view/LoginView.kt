package com.example.potluck.view

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.potluck.HomeActivity
import com.example.potluck.R
import com.example.potluck.ui.components.CustomButton
import com.example.potluck.ui.components.ButtonStyle
import com.example.potluck.viewmodel.LoginViewModel

@Composable
fun LoginView(modifier: Modifier = Modifier, viewModel: LoginViewModel = remember { LoginViewModel() }) {
    val isFormValid = viewModel.isFormValid()
    val context = LocalContext.current
    var showPassword: Boolean by remember { mutableStateOf(false) }

    LaunchedEffect(viewModel.errorMessage) {
        if (viewModel.errorMessage.isNotEmpty()) {
            Toast.makeText(context, "Error: ${viewModel.errorMessage}", Toast.LENGTH_LONG).show()
            viewModel.errorMessage = ""
        }
    }

    LaunchedEffect(viewModel.isLoggedIn) {
        if (viewModel.isLoggedIn) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }

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
            trailingIcon = {
                if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "show_password"
                        )
                    }
                } else {
                    IconButton(
                        onClick = { showPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "hide_password"
                        )
                    }
                }
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
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
        }
    }
}