package com.rahulghag.tasty.data.remote

import com.rahulghag.tasty.data.remote.dtos.RecipeCollectionDto
import com.rahulghag.tasty.data.remote.dtos.RecipeDto
import retrofit2.http.GET

interface TastyApi {
    @GET("recipes/collection")
    suspend fun getRecipeCollections(): List<RecipeCollectionDto>

    @GET("recipes")
    suspend fun getRecipes(): List<RecipeDto>
}