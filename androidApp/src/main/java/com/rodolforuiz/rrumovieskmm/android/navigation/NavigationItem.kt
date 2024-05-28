package com.rodolforuiz.rrumovieskmm.android.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screen(val description: String, val icon : ImageVector) {
    HOME("Home", Icons.Outlined.Home),
    PROFILE("Perfil", Icons.Outlined.Person),
    SAVED("Salvos", Icons.Outlined.FavoriteBorder),
}
sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)
    data object Profile : NavigationItem(Screen.PROFILE.name)
    data object Saved : NavigationItem(Screen.SAVED.name)
}