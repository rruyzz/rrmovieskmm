package com.rodolforuiz.rrumovieskmm.android.presentation

import com.rodolforuiz.rrumovieskmm.data.model.PopularMoviesItem

sealed class HomeState{
    data class UpdateFavorite(val movieDto: List<PopularMoviesItem>) : HomeState()
    data class Loading(val isLoading: Boolean) : HomeState()
}
