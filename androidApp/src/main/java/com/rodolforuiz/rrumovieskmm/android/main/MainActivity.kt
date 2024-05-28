package com.rodolforuiz.rrumovieskmm.android.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.rodolforuiz.rrumovieskmm.android.MyApplicationTheme
import com.rodolforuiz.rrumovieskmm.android.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        MainTabBar(navController)
                    }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AppNavHost(navController = navController, modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String, onClick: () -> Unit = {}) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = text)
        Button(
            //..
            onClick = {
                onClick.invoke()
            }
        ){
            Text("Show Result")
        }
    }
}

@Preview
@Composable
fun DefaultPreview( onClick: () -> Unit = {}) {
    MyApplicationTheme {
        GreetingView("Hello, Android!", onClick = {onClick.invoke()})
    }
}
