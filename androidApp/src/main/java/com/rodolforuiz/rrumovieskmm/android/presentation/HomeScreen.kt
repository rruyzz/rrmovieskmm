package com.rodolforuiz.rrumovieskmm.android.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.rodolforuiz.rrumovieskmm.android.GreetingView
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = koinViewModel(),
) {
    val uiState: String by viewModel.uiState.collectAsState()

    GreetingView(uiState)
}