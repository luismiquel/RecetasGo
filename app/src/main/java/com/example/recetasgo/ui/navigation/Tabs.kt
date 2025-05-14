package com.example.recetasgo.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recetasgo.data.Recipe
import com.example.recetasgo.ui.composables.RecipeList

@Composable
fun Tabs(categories: List<Map<String, List<Recipe>>>) {
    val titles = categories.map { it.keys.first() }
    var selected by remember { mutableStateOf(0) }
    Column {
        TabRow(selectedTabIndex = selected) {
            titles.forEachIndexed { index, title ->
                Tab(selected = selected == index, onClick = { selected = index }) {
                    Text(title, modifier = Modifier.padding(16.dp))
                }
            }
        }
        RecipeList(recipes = categories[selected].values.first())
    }
}
