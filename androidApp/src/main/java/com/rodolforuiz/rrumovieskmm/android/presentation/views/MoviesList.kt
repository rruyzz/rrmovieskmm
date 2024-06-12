package com.rodolforuiz.rrumovieskmm.android.presentation.views

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rodolforuiz.rrumovieskmm.data.model.PopularMoviesItem
import com.rodolforuiz.rrumovieskmm.domain.model.PopularMoviesDto


@Composable
fun MoviesList(
    moviesList: List<PopularMoviesDto>,
    selectItem: (PopularMoviesDto) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {
        itemsIndexed(moviesList) { index: Int, item: PopularMoviesDto ->
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
    movie: PopularMoviesDto,
    selectItem: (PopularMoviesDto) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            )
            .clickable{
                selectItem(movie)
            },
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .clip(shape = RoundedCornerShape(16.dp, 16.dp, 16.dp, 16.dp))
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