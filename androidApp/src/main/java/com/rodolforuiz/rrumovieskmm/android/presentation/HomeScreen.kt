package com.rodolforuiz.rrumovieskmm.android.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.rememberAsyncImagePainter
import com.rodolforuiz.rrumovieskmm.android.presentation.views.MovieDetail
import com.rodolforuiz.rrumovieskmm.android.presentation.views.MoviesList
import com.rodolforuiz.rrumovieskmm.android.presentation.views.ProgressIndicator
import com.rodolforuiz.rrumovieskmm.android.utils.cast
import com.rodolforuiz.rrumovieskmm.data.model.PopularMoviesItem
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
        is HomeState.HomeDetail -> MovieDetail(uiState.cast<HomeState.HomeDetail>().movieDto)
    }

}

