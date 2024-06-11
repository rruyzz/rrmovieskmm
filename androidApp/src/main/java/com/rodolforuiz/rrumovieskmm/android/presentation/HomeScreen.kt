package com.rodolforuiz.rrumovieskmm.android.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.rodolforuiz.rrumovieskmm.android.presentation.views.MovieDetail
import com.rodolforuiz.rrumovieskmm.android.presentation.views.MoviesList
import com.rodolforuiz.rrumovieskmm.android.presentation.views.ProgressIndicator
import com.rodolforuiz.rrumovieskmm.android.utils.cast
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = koinViewModel(),
) {
    val uiState: HomeState by viewModel.uiState.collectAsState()
    if (uiState is HomeState.HomeDetail) {
        BackHandler { viewModel.onMovieDetailBackClick() }
    }
    when(uiState) {
        is HomeState.Loading -> ProgressIndicator(uiState.cast<HomeState.Loading>().isLoading)
        is HomeState.HomeScreen ->  MoviesList(uiState.cast<HomeState.HomeScreen>().movieDto, selectItem = {
            viewModel.onMovieClick(it)
        })
        is HomeState.HomeDetail -> MovieDetail(uiState.cast<HomeState.HomeDetail>().movieDto,
            pressOnBack = {
                viewModel.onMovieDetailBackClick()
            }
        )
    }

}

