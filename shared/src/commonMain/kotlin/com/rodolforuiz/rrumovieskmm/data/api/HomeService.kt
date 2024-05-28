package com.rodolforuiz.rrumovieskmm.data.api

import com.rodolforuiz.rrumovieskmm.data.model.PopularMoviesResponse
import com.rodolforuiz.rrumovieskmm.network.KtorHttpClient
import io.ktor.client.call.body

class HomeService {
    private val ktorHttpClient = KtorHttpClient()

    suspend fun getPopularMovies(): PopularMoviesResponse {
        return ktorHttpClient.getKtorEndpoint("movie/popular").body<PopularMoviesResponse>()
    }
}