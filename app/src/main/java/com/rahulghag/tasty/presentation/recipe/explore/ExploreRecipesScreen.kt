package com.rahulghag.tasty.presentation.recipe.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.rahulghag.tasty.domain.entities.Recipe
import com.rahulghag.tasty.domain.entities.RecipeCollection
import com.rahulghag.tasty.presentation.components.SearchBar

@ExperimentalCoilApi
@Composable
fun ExploreRecipesScreen(
    navController: NavHostController,
    exploreRecipesViewModel: ExploreRecipesViewModel = hiltViewModel()
) {
    val uiState = exploreRecipesViewModel.uiState

    Scaffold(
        topBar = {
            SearchBar(
                onSearchBarClick = {}
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(24.dp),
            ) {
                items(uiState.recipeCollection) { recipeCollection ->
                    RecipeCollection(recipeCollection = recipeCollection)
                }
            }
            if (uiState.isFetchingRecipes) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun RecipeCollection(recipeCollection: RecipeCollection) {
    Column {
        Text(
            text = recipeCollection.type,
            modifier = Modifier
                .padding(start = 16.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(
            modifier = Modifier
                .height(12.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            items(recipeCollection.recipes) { recipe ->
                RecipeItem(recipe)
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun RecipeItem(recipe: Recipe) {
    Surface(
        modifier = Modifier
            .width(136.dp)
    ) {
        Column {
            Image(
                painter = rememberImagePainter(data = recipe.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(136.dp)
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.FillBounds
            )
            Spacer(
                modifier = Modifier
                    .height(4.dp)
            )
            Text(
                text = recipe.name,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
