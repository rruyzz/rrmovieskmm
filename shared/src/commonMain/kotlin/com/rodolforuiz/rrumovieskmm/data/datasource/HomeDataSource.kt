package com.rodolforuiz.rrumovieskmm.data.datasource

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeDataSource {
    operator fun invoke(): Flow<String> {
        return flow {
            delay(5000)
            emit("testefmdks")
        }
    }
}