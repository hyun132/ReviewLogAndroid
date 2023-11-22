package com.example.reviewlog.presentation.util

sealed class Screens(val route:String){
    object LoginScreen: Screens("login_screen")
    object SignUpScreen: Screens("signUp_screen")
    object HomeScreen: Screens("home_screen")
    object NewReviewScreen: Screens("new_review_screen")
}