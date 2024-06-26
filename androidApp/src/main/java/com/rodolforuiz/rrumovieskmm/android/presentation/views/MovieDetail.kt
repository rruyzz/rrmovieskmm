package com.rodolforuiz.rrumovieskmm.android.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rodolforuiz.rrumovieskmm.domain.model.PopularMoviesDto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetail(
    movie: PopularMoviesDto,
    pressOnBack: () -> Unit = {},
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = {
            RRMoviesToolbar(
                "Detail",
                pressOnBack = {
                    pressOnBack()
                },
                scrollBehavior = scrollBehavior,
                onFavoriteClick = {
                },
                isSaved = false
            )
        },
        content = {
            Surface(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                color = Color.Transparent
            ) {
                Box(
                    modifier = Modifier
                ) {
                    MovieBackground(movie = movie, modifier = Modifier)
                    Column(
                        modifier = Modifier.padding(0.dp, 117.dp, 0.dp, 0.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min)
                        )
                        {
                            Spacer(
                                modifier = Modifier
                                    .width(8.dp)
                            )
                            MoviePoster(movie = movie, modifier = Modifier)
                            Spacer(modifier = Modifier.width(8.dp))
                            TitleMovie(
                                movie = movie,
                                modifier = Modifier.fillMaxSize()
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        DescriptionMovie(
                            modifier = Modifier,
                            movie = movie,
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        TabRowComponent(description = movie.overview, movieId = movie.id.toString())
                    }
                }
            }
        }
    )
}

@Composable
fun DescriptionMovie(
    movie: PopularMoviesDto,
    modifier: Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)

    ) {
        Icon(
            imageVector = Icons.Outlined.Star,
            contentDescription = null,
            tint = Color.Gray
        )
        Spacer(modifier = Modifier.padding(4.dp, 0.dp))
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )
        Spacer(modifier = Modifier.padding(4.dp, 0.dp))
        Text(
            fontWeight = FontWeight.Light,
            text = movie.releaseDate.take(4),
            color = Color.Gray,
            modifier = Modifier
        )
    }
}

@Composable
fun TitleMovie(
    movie: PopularMoviesDto,
    modifier: Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Box {
            Text(
                text = movie.titleMovie,
                color = Color.White,
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
            )
        }
    }
}

@Composable
fun GradeMovieDescription(
    movie: PopularMoviesDto,
    modifier: Modifier,
) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(8.dp),
        horizontalArrangement = Arrangement.End,
    ) {
        Icon(
            imageVector = Icons.Outlined.Star,
            contentDescription = null,
            tint = Color(0xFFFF8700)
        )
        Spacer(
            modifier = Modifier
                .width(8.dp)
        )
        Text(
            text = movie.voteAverage,
            color = Color(0xFFFF8700),
        )
        Spacer(
            modifier = Modifier.width(8.dp)
        )
    }
}

@Composable
fun MoviePoster(
    movie: PopularMoviesDto,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(16.dp, 16.dp, 16.dp, 16.dp))
    ) {
        Image(
            modifier = Modifier,
            painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500${movie.posterPath}"),
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun MovieBackground(
    movie: PopularMoviesDto,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .height(234.dp)
            .clip(shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp)),
    ) {
        Image(
            modifier = modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500${movie.backdropPath}"),
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
        GradeMovieDescription(
            movie = movie,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RRMoviesToolbar(
    text: String,
    pressOnBack: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior,
    onFavoriteClick: () -> Unit,
    isSaved: Boolean,
) {
    val colorState = rememberSaveable { mutableStateOf(isSaved) }
    val isSavedState = colorState.value
    val iconColor = if (isSavedState) Color.Red else Color.White
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        title = {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
            )
        },
        navigationIcon = {
            IconButton(onClick = { pressOnBack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description",
                    modifier = Modifier
                        .padding(8.dp),
                    tint = Color.White,
                )
            }
        },
        actions = {
            IconButton(onClick = {
                colorState.value = isSavedState.not()
                onFavoriteClick()
            }) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                    tint = iconColor,
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}