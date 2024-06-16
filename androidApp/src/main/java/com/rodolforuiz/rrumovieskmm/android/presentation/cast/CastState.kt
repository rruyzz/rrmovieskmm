package com.rodolforuiz.rrumovieskmm.android.presentation.cast

import com.rodolforuiz.rrumovieskmm.domain.model.Actor

sealed class CastState {
    data class CastScreen(val actorsList: List<Actor>) : CastState()
    data class Loading(val isLoading: Boolean) : CastState()
}