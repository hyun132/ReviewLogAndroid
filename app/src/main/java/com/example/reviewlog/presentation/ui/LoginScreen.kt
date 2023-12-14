package com.example.reviewlog.presentation.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.reviewlog.presentation.ui.theme.ReviewLogTheme
import com.example.reviewlog.presentation.util.Screens

@Composable
fun LoginScreen(onNavToLogin: NavHostController, viewModel: LoginViewModel) {
    var id: String by remember {
        mutableStateOf("")
    }
    var password: String by remember {
        mutableStateOf("")
    }
    val uiState = viewModel.state
    ReviewLogTheme {
        if (!uiState.navigate.isNullOrEmpty()) {
            LaunchedEffect(key1 = true, block = {
                onNavToLogin.navigate(uiState.navigate!!)
            })
        }
        Column(Modifier.fillMaxSize()) {
            TextField(
                value = id,
                onValueChange = { input -> id = input },
                modifier = Modifier.border(width = 1.dp, color = Color.Black)
            )
            TextField(
                value = password,
                onValueChange = { input -> password = input },
                modifier = Modifier.border(width = 1.dp, color = Color.Black)
            )
            Button(onClick = { viewModel.login(id, password) }) {
                Text(text = "로그인")
            }
            Button(onClick = { onNavToLogin.navigate(Screens.SignUpScreen.route) }) {
                Text(text = "회원가입")
            }
        }
    }
}
