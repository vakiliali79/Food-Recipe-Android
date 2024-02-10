package com.alivakili.food_recipe.recipeData

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class SingleRecipe(
    val totalTime: String="",
    val foodName:String="",
    val calories: Double=0.0,
     val ingredients: ArrayList<String> = ArrayList(),
    val imageUrl:String=""
) : Parcelable
