package com.rahulghag.tasty.domain.usecases

import com.rahulghag.tasty.common.Result
import com.rahulghag.tasty.domain.entities.Recipe
import com.rahulghag.tasty.domain.repositories.RecipeRepository
import kotlinx.coroutines.flow.Flow

class GetRecipesUseCase(
    private val recipeRepository: RecipeRepository
) {
    operator fun invoke(): Flow<Result<List<Recipe>>> {
        return recipeRepository.getRecipes()
    }
}