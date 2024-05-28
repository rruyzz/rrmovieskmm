package com.rodolforuiz.rrumovieskmm.android.utils


inline fun <reified T : Any> Any.cast(): T {
    return this as T
}