package com.rahulghag.tasty.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rahulghag.tasty.navigation.Screen
import com.rahulghag.tasty.ui.theme.bottomBarBackgroundColor
import com.rahulghag.tasty.ui.theme.bottomBarSelectedContentColor

@ExperimentalAnimationApi
@Composable
fun BottomBar(
    navController: NavHostController,
    isBottomBarVisible: MutableState<Boolean>
) {
    AnimatedVisibility(
        visible = isBottomBarVisible.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.bottomBarBackgroundColor
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            tabs.forEach { screen ->
                BottomNavigationItem(
                    icon = {
                        screen.icon?.let {
                            Icon(
                                imageVector = it,
                                contentDescription = null
                            )
                        }
                    },
                    label = {
                        screen.title?.let {
                            Text(
                                text = stringResource(id = it),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    },
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    selectedContentColor = MaterialTheme.colors.bottomBarSelectedContentColor,
                    unselectedContentColor = Color.Gray
                )
            }
        }
    }
}

val tabs = listOf(
    Screen.ExploreRecipes,
    Screen.FavouriteRecipes,
)