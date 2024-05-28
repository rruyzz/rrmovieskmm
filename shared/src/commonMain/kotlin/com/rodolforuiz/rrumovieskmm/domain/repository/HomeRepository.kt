package com.rodolforuiz.rrumovieskmm.domain.repository

import com.rodolforuiz.rrumovieskmm.data.model.PopularMoviesResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getHome() : Flow<PopularMoviesResponse>
}