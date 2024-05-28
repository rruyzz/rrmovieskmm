package com.rodolforuiz.rrumovieskmm.android.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodolforuiz.rrumovieskmm.data.model.PopularMoviesItem
import com.rodolforuiz.rrumovieskmm.domain.usecase.HomeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val homeUseCase: HomeUseCase,
): ViewModel() {

    private val _uiState = MutableStateFlow<HomeState>(HomeState.Loading(false))
    val uiState = _uiState.asStateFlow()

    init {
        onInit()
    }
    fun onInit() = viewModelScope.launch {
        homeUseCase.invoke()
            .onStart { _uiState.emit(HomeState.Loading(isLoading = true)) }
//            .onCompletion { _uiState.emit(HomeState.Loading(isLoading = false)) }
            .collect { _uiState.emit(HomeState.HomeScreen(movieDto = it.results.orEmpty())) }
    }

    fun onMovieClick(movie: PopularMoviesItem) = viewModelScope.launch {
        _uiState.emit(HomeState.HomeDetail(movieDto = movie))
    }

    fun onMovieDetailBackClick() =  viewModelScope.launch {
        onInit()
    }
}