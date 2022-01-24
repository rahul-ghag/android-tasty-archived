package com.rahulghag.tasty.data.repositories

import com.rahulghag.tasty.common.Result
import com.rahulghag.tasty.data.remote.TastyApi
import com.rahulghag.tasty.domain.entities.Recipe
import com.rahulghag.tasty.domain.entities.RecipeCollection
import com.rahulghag.tasty.domain.repositories.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class RecipeRepositoryImpl(
    private val tastyApi: TastyApi
) : RecipeRepository {
    override fun getRecipeCollections(): Flow<Result<List<RecipeCollection>>> = flow {
        try {
            val recipeCollections = tastyApi.getRecipeCollections().map { it.toRecipeCollection() }
            emit(Result.Success(recipeCollections))
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> {
                    emit(Result.NetworkError)
                }
                is HttpException -> {
                    val code = throwable.code()
                    val errorMessage = throwable.localizedMessage
                    emit(Result.Error(code = code, errorMessage = errorMessage))
                }
                else -> {
                    emit(Result.Error())
                }
            }
        }
    }

    override fun getRecipes(): Flow<Result<List<Recipe>>> = flow {
        try {
            val recipes = tastyApi.getRecipes().map { it.toRecipe() }
            emit(Result.Success(recipes))
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> emit(Result.NetworkError)
                is HttpException -> {
                    val code = throwable.code()
                    val errorMessage = throwable.localizedMessage
                    emit(Result.Error(code = code, errorMessage = errorMessage))
                }
                else -> {
                    emit(Result.Error())
                }
            }
        }
    }
}