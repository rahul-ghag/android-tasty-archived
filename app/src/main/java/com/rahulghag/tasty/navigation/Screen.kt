package com.rahulghag.tasty.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.ui.graphics.vector.ImageVector
import com.rahulghag.tasty.R

sealed class Screen(
    val route: String,
    @StringRes val title: Int? = null,
    val icon: ImageVector? = null
) {
    object Splash : Screen(route = "splash")

    object Onboarding : Screen(route = "onboarding")

    object ExploreRecipes : Screen(
        route = "recipes/explore",
        title = R.string.title_explore,
        icon = Icons.Rounded.Explore
    )

    object FavouriteRecipes : Screen(
        route = "recipes/favourite",
        title = R.string.title_my_recipes,
        icon = Icons.Rounded.Favorite
    )

    object SearchRecipes : Screen(route = "recipes/search")

    object RecipeDetail : Screen(route = "recipe/{recipeId}") {
        fun passRecipeId(recipeId: Int): String {
            return "recipe$recipeId"
        }
    }
}