package com.rodolforuiz.rrumovieskmm.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rodolforuiz.rrumovieskmm.android.main.GreetingView
import com.rodolforuiz.rrumovieskmm.android.presentation.HomeScreen
import com.rodolforuiz.rrumovieskmm.android.presentation.ProgressIndicator

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.DETAIL.route) {
            GreetingView("dsad")
//            LoginScreen(navController)
        }
    }
}