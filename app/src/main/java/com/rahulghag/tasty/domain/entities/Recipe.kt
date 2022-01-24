package com.rahulghag.tasty.domain.entities

import com.rahulghag.tasty.common.Constants.BASE_URL

data class Recipe(
    val id: Int,
    val image: String,
    val name: String,
    val presentedBy: String
) {
    val imageUrl get() = "$BASE_URL$image"
}