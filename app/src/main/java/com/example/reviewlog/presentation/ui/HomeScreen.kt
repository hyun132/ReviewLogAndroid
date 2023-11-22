package com.example.reviewlog.presentation.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.reviewlog.presentation.util.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold() { innerPadding ->

        Row(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Home Screen")

            Button(onClick = {navController.navigate(Screens.NewReviewScreen.route)}) {
                Text(text = "to NewReviewScreen")
            }
        }

    }
}