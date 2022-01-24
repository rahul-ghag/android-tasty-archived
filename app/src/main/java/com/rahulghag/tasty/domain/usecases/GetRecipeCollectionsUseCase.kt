package com.rahulghag.tasty.domain.usecases

import com.rahulghag.tasty.common.Result
import com.rahulghag.tasty.domain.entities.RecipeCollection
import com.rahulghag.tasty.domain.repositories.RecipeRepository
import kotlinx.coroutines.flow.Flow

class GetRecipeCollectionsUseCase(
    private val recipeRepository: RecipeRepository
) {
    operator fun invoke(): Flow<Result<List<RecipeCollection>>> {
        return recipeRepository.getRecipeCollections()
    }
}