package com.rahulghag.tasty.data.remote.dtos


import com.rahulghag.tasty.domain.entities.RecipeCollection
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeCollectionDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("recipes")
    val recipes: List<RecipeDto>,
    @SerialName("type")
    val type: String
) {
    fun toRecipeCollection(): RecipeCollection {
        return RecipeCollection(
            id = id,
            name = name,
            recipes = recipes.map { it.toRecipe() },
            type = type
        )
    }
}