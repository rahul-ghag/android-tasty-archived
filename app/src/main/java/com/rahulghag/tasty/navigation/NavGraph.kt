package com.rahulghag.tasty.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.rahulghag.tasty.presentation.onboarding.OnboardingScreen
import com.rahulghag.tasty.presentation.recipe.detail.RecipeDetailScreen
import com.rahulghag.tasty.presentation.recipe.explore.ExploreRecipesScreen
import com.rahulghag.tasty.presentation.recipe.favourite.FavouriteRecipesScreen
import com.rahulghag.tasty.presentation.recipe.search.SearchRecipesScreen
import com.rahulghag.tasty.presentation.splash.SplashScreen

@ExperimentalCoilApi
@Composable
fun NavGraph(
    navController: NavHostController,
    isBottomBarVisible: MutableState<Boolean>
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ExploreRecipes.route
    ) {
        composable(route = Screen.Splash.route) {
            isBottomBarVisible.value = false
            SplashScreen(navController)
        }
        composable(route = Screen.Onboarding.route) {
            isBottomBarVisible.value = false
            OnboardingScreen(navController)
        }
        composable(route = Screen.ExploreRecipes.route) {
            isBottomBarVisible.value = true
            ExploreRecipesScreen(navController)
        }
        composable(route = Screen.FavouriteRecipes.route) {
            isBottomBarVisible.value = true
            FavouriteRecipesScreen(navController)
        }
        composable(route = Screen.SearchRecipes.route) {
            isBottomBarVisible.value = false
            SearchRecipesScreen(navController)
        }
        composable(
            route = Screen.RecipeDetail.route,
            arguments = listOf(navArgument("recipeId") {
                type = NavType.IntType
            })
        ) {
            isBottomBarVisible.value = false
            RecipeDetailScreen(navController)
        }
    }
}