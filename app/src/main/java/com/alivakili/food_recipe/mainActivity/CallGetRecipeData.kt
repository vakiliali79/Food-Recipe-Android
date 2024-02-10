package com.alivakili.food_recipe.mainActivity

data class CallGetRecipeData(
    var searchText: String="",
    var appId: String="",
    var apiKey: String="",
    var diet: ArrayList<String>,
    var health: ArrayList<String>,
    var cuisineType: ArrayList<String>,
    var mealType: ArrayList<String>,
    var dishType: ArrayList<String>



)