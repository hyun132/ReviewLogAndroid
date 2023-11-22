package com.example.reviewlog.presentation.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.reviewlog.presentation.ui.theme.ReviewLogTheme

@Composable
fun LoginScreen(navController: NavController) {
    var id: String by remember {
        mutableStateOf("")
    }
    var password: String by remember {
        mutableStateOf("")
    }

    ReviewLogTheme {
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
            Button(onClick = { /*TODO*/ }) {
                Text(text = "로그인")
            }
        }
    }
}
