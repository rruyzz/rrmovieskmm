package com.rodolforuiz.rrumovieskmm.android.presentation

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
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.rodolforuiz.rrumovieskmm.android.utils.cast
import com.rodolforuiz.rrumovieskmm.data.model.PopularMoviesItem
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = koinViewModel(),
) {
    val uiState: HomeState by viewModel.uiState.collectAsState()
    when(uiState) {
        is HomeState.Loading -> ProgressIndicator(uiState.cast<HomeState.Loading>().isLoading)
        is HomeState.UpdateFavorite ->  MoviesList(uiState.cast<HomeState.UpdateFavorite>().movieDto, selectItem = {
            navController.navigate("DETAIL")

        })
        else -> {}
    }

}

@Composable
fun ProgressIndicator(
    isLoading: Boolean,
    modifier: Modifier = Modifier,
) {
    if(isLoading) CircularProgressIndicator()
}

@Composable
fun MoviesList(
    moviesList: List<PopularMoviesItem>,
    selectItem: (Int) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {
        itemsIndexed(moviesList) { index: Int, item: PopularMoviesItem ->
            Movies(
                movie = item,
                selectItem = {
                    selectItem(it)
                }
            )
        }
    }
}

@Composable
fun Movies(
    movie: PopularMoviesItem,
    selectItem: (Int) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            )
            .clickable{
                selectItem(movie.id ?: 0)
            },
    ) {
        Box(
            modifier = Modifier.height(200.dp
            )
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500${movie.posterPath}"),
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
        }
    }
}