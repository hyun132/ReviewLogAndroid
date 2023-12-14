package com.example.reviewlog.presentation.ui

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.reviewlog.model.Address
import com.example.reviewlog.presentation.ui.theme.ReviewLogTheme

@Composable
fun SignUpScreen(onNavToLogin: ()->Unit, viewModel : SignUpViewModel) {

    var id: String by remember {
        mutableStateOf("")
    }
    var password: String by remember {
        mutableStateOf("")
    }
    var nickName: String by remember {
        mutableStateOf("")
    }
    var address: String by remember {
        mutableStateOf("")
    }

    val uiState = viewModel.state
    ReviewLogTheme {
        if(!uiState.result.isNullOrEmpty()) {
            LaunchedEffect(key1 = true, block = {
                Log.d("signUp: ","uistate : $uiState")
                onNavToLogin()
            })
        }
        Column (Modifier.fillMaxSize()){
            TextField(
                value = id,
                onValueChange = { input -> id = input },
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            TextField(
                value = password,
                onValueChange = { input -> password = input },
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            TextField(
                value = nickName,
                onValueChange = { input -> nickName = input },
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            TextField(
                value = address,
                onValueChange = { input -> address = input },
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            Button(onClick = { viewModel.signUp(id, password, nickName, Address()) }) {
                Text(text = "회원가입")
            }
        }

    }
}