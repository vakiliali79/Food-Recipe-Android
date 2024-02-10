package com.alivakili.a202_2.api

import com.alivakili.food_recipe.recipeData.RecipeDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {
    //ap id "903328d6"
    // api key "d1a9f80a8356c671f41b4db3ee0e9fb3"
    @GET("recipes/v2/")
    fun getRecipe(
        @Query("q") searchText:String?,
        @Query("app_id") appId:String?,
        @Query("app_key") apiKey:String?,
        @Query("diet") diet: Array<String>,
        @Query("health") health: Array<String>,
        @Query("cuisineType") cuisineType: Array<String>,
        @Query("mealType") mealType: Array<String>,
        @Query("dishType") dishType: Array<String>,
        @Query("type") type:String?,
        ):Call<RecipeDTO>
}
