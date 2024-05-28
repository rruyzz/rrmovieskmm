package com.rodolforuiz.rrumovieskmm.android.navigation

import androidx.annotation.DrawableRes
import com.rodolforuiz.rrumovieskmm.android.R

enum class Screen(val description: String, @DrawableRes val resourceId: Int) {
    HOME("Home", R.drawable.ic_home),
    PROFILE("Perfil", R.drawable.ic_person),
    SAVED("Salvos", R.drawable.ic_save),
    SEARCH("Procurar", R.drawable.ic_search),
}
sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)
    data object Profile : NavigationItem(Screen.PROFILE.name)
    data object Saved : NavigationItem(Screen.SAVED.name)
    data object Search : NavigationItem(Screen.SEARCH.name)
}