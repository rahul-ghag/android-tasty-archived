package com.rahulghag.tasty.domain.entities

data class RecipeCollection(
    val id: Int,
    val name: String,
    val recipes: List<Recipe>,
    val type: String
)