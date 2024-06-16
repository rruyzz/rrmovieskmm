package com.rodolforuiz.rrumovieskmm.android.presentation.cast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodolforuiz.rrumovieskmm.domain.model.Actor
import com.rodolforuiz.rrumovieskmm.domain.usecase.CastUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CastScreenViewModel(
    private val castUseCase: CastUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<CastState>(CastState.Loading(false))
    val uiState = _uiState.asStateFlow()

    fun onInit(movieId: String) = viewModelScope.launch {
        castUseCase.invoke(movieId)
            .onStart { _uiState.emit(CastState.Loading(isLoading = true)) }
            .collect { handleSuccess(actorsList = it.actorList) }
    }

    private fun handleSuccess(actorsList: List<Actor>) = viewModelScope.launch {
        println("ListCard: ${actorsList.toList()}")
        _uiState.emit(CastState.CastScreen(actorsList = actorsList))
    }
}