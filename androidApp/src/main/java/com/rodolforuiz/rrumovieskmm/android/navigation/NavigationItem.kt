package com.rodolforuiz.rrumovieskmm.android.navigation

enum class Screen {
    HOME,
    DETAIL,
}
sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)
    data object DETAIL : NavigationItem(Screen.DETAIL.name)
}