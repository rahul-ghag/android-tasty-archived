package com.rahulghag.tasty.data.remote.dtos

import com.rahulghag.tasty.domain.entities.Recipe
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDto(
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("name")
    val name: String,
    @SerialName("presented_by")
    val presentedBy: String
) {
    fun toRecipe(): Recipe {
        return Recipe(
            id = id,
            image = image,
            name = name,
            presentedBy = presentedBy
        )
    }
}