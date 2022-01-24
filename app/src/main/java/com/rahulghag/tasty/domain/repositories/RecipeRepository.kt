package com.rahulghag.tasty.domain.repositories

import com.rahulghag.tasty.common.Result
import com.rahulghag.tasty.domain.entities.Recipe
import com.rahulghag.tasty.domain.entities.RecipeCollection
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getRecipeCollections(): Flow<Result<List<RecipeCollection>>>

    fun getRecipes(): Flow<Result<List<Recipe>>>
}