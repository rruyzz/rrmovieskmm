package com.rodolforuiz.rrumovieskmm.data.api

import com.rodolforuiz.rrumovieskmm.network.KtorHttpClient

class HomeService {
    private val ktorHttpClient = KtorHttpClient()

    suspend fun greeting(): String {
        return ktorHttpClient.getData("movie/popular")
    }
}