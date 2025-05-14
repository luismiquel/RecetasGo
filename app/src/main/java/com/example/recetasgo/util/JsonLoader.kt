package com.example.recetasgo.util

import android.content.Context
import com.example.recetasgo.data.Recipe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonLoader {
    fun loadRecipes(context: Context): List<Map<String, List<Recipe>>> {
        val json = context.assets.open("recipes.json").bufferedReader().use { it.readText() }
        val type = object : TypeToken<List<Map<String, List<Recipe>>>>() {}.type
        return Gson().fromJson(json, type)
    }
}
