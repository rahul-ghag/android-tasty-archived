package com.rahulghag.tasty.presentation.recipe.explore

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulghag.tasty.common.Result
import com.rahulghag.tasty.domain.usecases.GetRecipeCollectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ExploreRecipesViewModel @Inject constructor(
    getRecipeCollectionsUseCase: GetRecipeCollectionsUseCase
) : ViewModel() {
    var uiState by mutableStateOf(ExploreRecipesUiState(isFetchingRecipes = true))
        private set

    init {
        getRecipeCollectionsUseCase().onEach { result ->
            when (result) {
                is Result.Success -> {
                    uiState =
                        ExploreRecipesUiState(recipeCollection = result.data)
                }
                is Result.NetworkError -> {

                }
                is Result.Error -> {
                }
            }
        }.launchIn(viewModelScope)
    }
}