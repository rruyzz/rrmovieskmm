package com.rodolforuiz.rrumovieskmm.domain.repository

import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getHome() : Flow<String>
}