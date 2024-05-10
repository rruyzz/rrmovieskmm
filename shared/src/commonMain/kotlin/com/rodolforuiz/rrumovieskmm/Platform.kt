package com.rodolforuiz.rrumovieskmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform