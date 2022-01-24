package com.rahulghag.tasty.di

import com.rahulghag.tasty.data.remote.TastyApi
import com.rahulghag.tasty.data.repositories.RecipeRepositoryImpl
import com.rahulghag.tasty.domain.repositories.RecipeRepository
import com.rahulghag.tasty.domain.usecases.GetRecipeCollectionsUseCase
import com.rahulghag.tasty.domain.usecases.GetRecipesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RecipeModule {
    @Provides
    @Singleton
    fun provideRecipeRepository(tastyApi: TastyApi): RecipeRepository {
        return RecipeRepositoryImpl(tastyApi)
    }

    @Provides
    @Singleton
    fun provideGetRecipeCollections(recipeRepository: RecipeRepository): GetRecipeCollectionsUseCase {
        return GetRecipeCollectionsUseCase(recipeRepository)
    }

    @Provides
    @Singleton
    fun provideGetRecipesUseCase(recipeRepository: RecipeRepository): GetRecipesUseCase {
        return GetRecipesUseCase(recipeRepository)
    }
}