package com.rodolforuiz.rrumovieskmm.domain.repository

import com.rodolforuiz.rrumovieskmm.data.model.CastResponse
import kotlinx.coroutines.flow.Flow

interface CastRepository {
    suspend fun getCast(movieId: String) : Flow<CastResponse>
}