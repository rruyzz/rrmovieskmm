package com.rodolforuiz.rrumovieskmm.data.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class HomeService {
    private val client = HttpClient()

    suspend fun greeting(): String {
        val response = client.get("https://api.themoviedb.org/3/movie/popular"){
            url {
                parameters.append("api_key", "e591023d8d396231d3045ea6341a6fd2")
                parameters.append("language", "pt-BR")
            }
        }
        return response.bodyAsText()
    }
}