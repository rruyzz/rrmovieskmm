package com.rodolforuiz.rrumovieskmm.android.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rodolforuiz.rrumovieskmm.android.navigation.Screen

class MainTabBar {
}
@Composable
fun MainTabBar(navController: NavHostController) {
    val items = listOf(
        Screen.HOME,
        Screen.SEARCH,
        Screen.SAVED,
    )
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .background(Color(0xFF0296E5))
                .height(1.dp)
                .fillMaxWidth()
        )

        BottomNavigation(
            backgroundColor = MaterialTheme.colorScheme.background,
            modifier = Modifier.height(95.dp)
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            items.forEach { screenItem ->
                val currentRoute = currentDestination?.route; //check current route
                val selected = currentRoute == screenItem.name
                BottomNavigationItem(
                    modifier = Modifier.fillMaxSize(),
                    icon = {
                        Icon(
                            painter = painterResource(screenItem.resourceId),
                            contentDescription = null,
                            tint = if (selected) Color(0xFF0296E5)
                            else Color.Gray,
                            modifier = Modifier.offset(y = (-12).dp),
                        )
                    },
                    label = {
                        Text(
                            text = screenItem.description,
                            color = if (selected) Color(0xFF0296E5)
                            else Color.Gray,
                            fontWeight = FontWeight.Light,
                        )
                    },
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
}