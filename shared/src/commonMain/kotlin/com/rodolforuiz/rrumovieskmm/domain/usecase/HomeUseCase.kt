package com.rodolforuiz.rrumovieskmm.domain.usecase

import com.rodolforuiz.rrumovieskmm.data.repository.HomeRepositoryImpl
import kotlinx.coroutines.flow.Flow

class HomeUseCase(
    private val repository: HomeRepositoryImpl
) {

    suspend operator fun invoke(): Flow<String> {
        return repository.getHome()
    }
}