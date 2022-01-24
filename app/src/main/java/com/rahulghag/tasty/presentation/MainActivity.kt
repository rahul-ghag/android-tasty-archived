package com.rahulghag.tasty.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.rahulghag.tasty.navigation.NavGraph
import com.rahulghag.tasty.presentation.components.BottomBar
import com.rahulghag.tasty.ui.theme.TastyTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isBottomBarVisible = rememberSaveable { (mutableStateOf(true)) }

            TastyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomBar(
                                navController = navController,
                                isBottomBarVisible = isBottomBarVisible
                            )
                        }
                    ) {
                        NavGraph(
                            navController = navController,
                            isBottomBarVisible = isBottomBarVisible
                        )
                    }
                }
            }
        }
    }
}