package com.rodolforuiz.rrumovieskmm.android.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rodolforuiz.rrumovieskmm.android.MyApplicationTheme
import com.rodolforuiz.rrumovieskmm.android.navigation.AppNavHost
import com.rodolforuiz.rrumovieskmm.android.navigation.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                val items = listOf(
                    Screen.HOME,
                    Screen.PROFILE,
                    Screen.SAVED,
                )
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigation {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            items.forEach { screenItem ->
                                BottomNavigationItem(
                                    icon = { Icon(screenItem.icon, contentDescription = null) },
                                    label = { Text(screenItem.description) },
                                    selected = currentDestination?.hierarchy?.any { it.route == screenItem.name } == true,
                                    onClick = {
                                        navController.navigate(screenItem.name) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AppNavHost(navController = navController, modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String, onClick: () -> Unit = {}) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = text)
        Button(
            //..
            onClick = {
                onClick.invoke()
            }
        ){
            Text("Show Result")
        }
    }
}

@Preview
@Composable
fun DefaultPreview( onClick: () -> Unit = {}) {
    MyApplicationTheme {
        GreetingView("Hello, Android!", onClick = {onClick.invoke()})
    }
}
