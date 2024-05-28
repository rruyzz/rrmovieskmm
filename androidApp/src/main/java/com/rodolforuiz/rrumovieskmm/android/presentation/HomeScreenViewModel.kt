package com.rodolforuiz.rrumovieskmm.android.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodolforuiz.rrumovieskmm.domain.usecase.HomeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val homeUseCase: HomeUseCase,
): ViewModel() {

    private val _uiState = MutableStateFlow<String>(String())
    val uiState = _uiState.asStateFlow()

    init {
        onInit()
    }
    private fun onInit() = viewModelScope.launch {
        homeUseCase.invoke()
            .onStart { _uiState.emit("loading") }
            .collect{ _uiState.emit(it.results?.first()?.titleMovie.orEmpty()) }
    }
}