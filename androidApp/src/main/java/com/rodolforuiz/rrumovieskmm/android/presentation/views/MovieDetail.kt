package com.rodolforuiz.rrumovieskmm.android.presentation.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rodolforuiz.rrumovieskmm.data.model.PopularMoviesItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetail(
    movie: PopularMoviesItem,
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
            LazyColumn(
                modifier = Modifier.padding(it)
            ) {

            }
        }
    )
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
            } ) {
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