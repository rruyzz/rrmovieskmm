package com.rodolforuiz.rrumovieskmm.android.presentation

import com.rodolforuiz.rrumovieskmm.domain.model.PopularMoviesDto

sealed class HomeState{
    data class HomeScreen(val movieDto: List<PopularMoviesDto>) : HomeState()
    data class Loading(val isLoading: Boolean) : HomeState()
    data class HomeDetail(val movieDto: PopularMoviesDto) : HomeState()
}
