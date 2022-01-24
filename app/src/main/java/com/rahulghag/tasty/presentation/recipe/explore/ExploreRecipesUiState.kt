package com.rahulghag.tasty.presentation.recipe.explore

import com.rahulghag.tasty.domain.entities.Recipe
import com.rahulghag.tasty.domain.entities.RecipeCollection

data class ExploreRecipesUiState(
    val recipeCollection: List<RecipeCollection> = emptyList(),
    val recipes: List<Recipe> = emptyList(),
    val isFetchingRecipes: Boolean = false
)