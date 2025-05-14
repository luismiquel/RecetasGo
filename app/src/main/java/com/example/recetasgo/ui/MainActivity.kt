package com.example.recetasgo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.recetasgo.ui.theme.Theme
import com.example.recetasgo.ui.navigation.Tabs
import com.example.recetasgo.util.JsonLoader

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val allData = JsonLoader.loadRecipes(this)
        setContent {
            Theme {
                Tabs(categories = allData)
            }
        }
    }
}
