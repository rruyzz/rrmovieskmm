package com.rodolforuiz.rrumovieskmm.android.presentation.cast

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rodolforuiz.rrumovieskmm.android.utils.cast
import com.rodolforuiz.rrumovieskmm.domain.model.Actor
import org.koin.androidx.compose.koinViewModel

@Composable
fun CastScreen(
    movieId: String,
    viewModel: CastScreenViewModel = koinViewModel()
) {
    val uiState: CastState by viewModel.uiState.collectAsState()
    when (uiState) {
        is CastState.Loading -> ProgressIndicator(uiState.cast<CastState.Loading>().isLoading)
        is CastState.CastScreen -> ActorsList(uiState.cast<CastState.CastScreen>().actorsList.take(6))
    }

    LaunchedEffect(key1 = viewModel, block = {
        viewModel.onInit(movieId)
    })
}


@Composable
fun ActorsList(
    moviesList: List<Actor>,
    modifier: Modifier = Modifier
) {
    println("ListCardViewModel: ${moviesList.toList()}")

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        println("ItemDALISTA ${moviesList.size}")

        moviesList.forEach {
            println("ItemDALISTA ${it.name}")
        }
        Column(
            modifier = modifier
                .weight(0.5f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Actor(moviesList[0])
            Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())
            Text(text = moviesList[0].name)

            Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())

            Actor(moviesList[2])
            Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())
            Text(text = moviesList[2].name)

            Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())

            Actor(moviesList[4])
            Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())
            Text(text = moviesList[4].name)

            Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())
        }
        Column(
            modifier = modifier
                .weight(0.5f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Actor(moviesList[1])
            Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())
            Text(text = moviesList[1].name)

            Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())

            Actor(moviesList[3])
            Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())
            Text(text = moviesList[3].name)

            Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())

            Actor(moviesList[5])
            Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())
            Text(text = moviesList[5].name)

            Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())
        }
    }
}

@Composable
fun Actor(
    actor: Actor,
    modifier: Modifier = Modifier.background(Color.Gray)
) {
    Image(
        painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500${actor.image}"),
        contentDescription = "avatar",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
    )
}


@Composable
fun ProgressIndicator(
    isLoading: Boolean,
) {
    Box(
        modifier = Modifier
            .padding(44.dp)
            .wrapContentSize()
            .fillMaxWidth()

        ,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(32.dp).align(Alignment.Center),
            color = Color.LightGray,
        )
    }
}
