package com.alivakili.food_recipe.mainActivity

import com.alivakili.food_recipe.recipeData.RecipeDTO

sealed class MainState {
    object Loading: MainState()
    data class Success(val recipeDOT: RecipeDTO?): MainState()
    object Failure: MainState()
}