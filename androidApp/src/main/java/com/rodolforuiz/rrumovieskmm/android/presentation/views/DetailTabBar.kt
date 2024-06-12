package com.rodolforuiz.rrumovieskmm.android.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rodolforuiz.rrumovieskmm.android.main.GreetingView

@Composable
fun TabRowComponent(
    modifier: Modifier = Modifier,
) {
    val tabs = listOf(
        "Sobre o filme",
        "Elenco",
    )
    // State to keep track of the selected tab index
    var selectedTabIndex by remember { mutableStateOf(0) }

    // Column layout to arrange tabs vertically and display content screens
    Column(modifier = modifier) {
        // TabRow composable to display tabs
        TabRow(
            selectedTabIndex = selectedTabIndex,
            contentColor = Color.White,
            backgroundColor = MaterialTheme.colorScheme.background,
            indicator = { tabPositions ->
                // Indicator for the selected tab
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = Color.Gray
                )
            }
        ) {
            // Iterate through each tab title and create a tab
            tabs.forEachIndexed { index, tabTitle ->
                Tab(
                    modifier = Modifier.padding(all = 16.dp).background(MaterialTheme.colorScheme.background),
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
                ) {
                    // Text displayed on the tab
                    Text(text = tabTitle)
                }
            }
        }

        // Display the content screen corresponding to the selected tab
        if(selectedTabIndex == 0) {
            GreetingView("Outro")
        } else {
            GreetingView("Search")
        }
//        contentScreens.getOrNull(selectedTabIndex)?.invoke()
    }
}
