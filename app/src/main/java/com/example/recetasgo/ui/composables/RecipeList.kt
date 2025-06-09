package com.example.recetasgo.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.recetasgo.data.Recipe

@Composable
fun RecipeList(recipes: List<Recipe>) {
    LazyColumn {
        items(recipes) { RecipeCard(it) }
    }
}

@Composable
fun RecipeCard(recipe: Recipe) {
    Card(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(data = "file:///android_asset/${recipe.image}"),
                contentDescription = recipe.title,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(recipe.title)
                Text(recipe.description)
                Text("Ingredientes: " + recipe.ingredients.joinToString(", "))
                Text("Tiempo: " + recipe.time)
            }
        }
    }
}
