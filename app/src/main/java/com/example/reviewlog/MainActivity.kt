package com.example.reviewlog

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reviewlog.presentation.ui.HomeScreen
import com.example.reviewlog.presentation.ui.LoginScreen
import com.example.reviewlog.presentation.ui.LoginViewModel
import com.example.reviewlog.presentation.ui.MainViewModel
import com.example.reviewlog.presentation.ui.NewReviewScreen
import com.example.reviewlog.presentation.ui.SignUpScreen
import com.example.reviewlog.presentation.ui.SignUpViewModel
import com.example.reviewlog.presentation.ui.theme.ReviewLogTheme
import com.example.reviewlog.presentation.util.Screens
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.PermissionsRequired
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReviewLogTheme {
                val permissionState = rememberMultiplePermissionsState(
                    listOf(
                        Manifest.permission.INTERNET,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                )

                val lifecycleOwner = LocalLifecycleOwner.current
                DisposableEffect(key1 = lifecycleOwner, effect = {
                    val observer = LifecycleEventObserver { _, event ->
                        if (event == Lifecycle.Event.ON_RESUME) {
                            permissionState.launchMultiplePermissionRequest()
                        }
                    }
                    lifecycleOwner.lifecycle.addObserver(observer)
                    onDispose {
                        lifecycleOwner.lifecycle.removeObserver(observer)
                    }
                })

                Surface {
                    Permissions(permissionState)
                }
            }
        }
    }

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun Permissions(
        multiplePermissionsState: MultiplePermissionsState
    ) {
        PermissionsRequired(
            multiplePermissionsState = multiplePermissionsState,
            permissionsNotGrantedContent = {
                Toast.makeText(
                    this,
                    "permissionsNotGrantedContent",
                    Toast.LENGTH_SHORT
                ).show()
            },
            permissionsNotAvailableContent = {
                Toast.makeText(
                    this,
                    "permissionsNotAvailableContent",
                    Toast.LENGTH_SHORT
                ).show()
            }) {

            val navHostController = rememberNavController()

            NavHost(
                navController = navHostController,
                startDestination = Screens.LoginScreen.route
            ) {
                composable(route = Screens.LoginScreen.route) {
                    LoginScreen(
                        navHostController,
                        hiltViewModel<LoginViewModel>()
                    )
                }
                composable(route = Screens.SignUpScreen.route) {
//                            val viewModel = hiltViewModel<SignUpViewModel>(it)
                    SignUpScreen(
                        { navHostController.navigate(Screens.LoginScreen.route) },
                        hiltViewModel<SignUpViewModel>()
                    )
                }
                composable(route = Screens.HomeScreen.route) {
                    HomeScreen(navHostController)
                }
                composable(route = Screens.NewReviewScreen.route) {
                    NewReviewScreen(navHostController)
                }
            }
        }
    }
}
