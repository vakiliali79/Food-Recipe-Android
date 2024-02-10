package com.alivakili.food_recipe.mainActivity

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.food_recipe.R
import com.alivakili.food_recipe.databinding.LayoutRecipeListBinding
import com.alivakili.food_recipe.recipeData.RecipeDTO
import com.alivakili.food_recipe.recipeData.SingleRecipe
import com.squareup.picasso.Picasso

class RecipeRecyclerViewAdapter (

    private val context: Context,
    private val items: RecipeDTO?,
    private val onClicked:(SingleRecipe)->Unit,
    ): RecyclerView.Adapter<RecipeRecyclerViewAdapter.RecipeViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
                RecipeViewHolder {
            return RecipeViewHolder.create(parent, onClicked)
        }



        override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
            val recipe= items?.hits?.get(position)
            holder.bind(recipe?.recipe,context)
        }



        override fun getItemCount(): Int {
            return items?.hits?.size ?: 0
        }

        class RecipeViewHolder(
            private val binding: LayoutRecipeListBinding,
            private val onClicked: (SingleRecipe) -> Unit
        ): RecyclerView.ViewHolder(binding.root)
        {

            companion object{
                fun create(parent: ViewGroup, onClicked:(SingleRecipe)->Unit): RecipeViewHolder {
                    val binding= LayoutRecipeListBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false)
                    return RecipeViewHolder(
                        binding = binding,
                        onClicked = onClicked
                    )
                }

            }

            fun bind(recipe: RecipeDTO.Hit.Recipe?, context: Context){

                binding.caloriesTV.text=recipe?.calories.toString()
                loadImage(recipe?.images?.sMALL?.url.toString(),context)
                binding.foodNameTV.text=recipe?.label

                binding.ingredientsTV.text=recipe?.ingredients?.size.toString()
                binding.caloriesTV.text=recipe?.calories.toString()
                binding.minutesTV.text=recipe?.totalTime.toString()
                val cuisines= getcuisineTypes(recipe?.cuisineType)
                binding.locationTV.text=cuisines
                var ingredient=SingleRecipe()
                for (temp in recipe?.ingredients!!)
                    temp?.text?.let { ingredient.ingredients.add(it) }
                val singleRecipe= recipe.calories?.let {
                    SingleRecipe(
                        totalTime = recipe.totalTime.toString(),
                        foodName = recipe.label.toString(),
                        calories = it,
                        ingredients = ingredient.ingredients,
                        imageUrl= recipe.images?.sMALL?.url.toString())
                }

                binding.root.setOnClickListener {
                    if (singleRecipe != null) {
                        onClicked(singleRecipe)
                    }
                }


            }

            private fun getcuisineTypes(cuisineType: List<String?>?):String{
                var cuisinesStr:String=""
                if (cuisineType != null) {
                    for (cuisine in cuisineType)
                        cuisinesStr=cuisinesStr+"\n"+cuisineType
                }
                return cuisinesStr
            }


            private fun loadImage(url:String?,context: Context) {
                Log.e("TAG", "loadImage: "+url )
                Picasso.with(context).load(url).fit().centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.foodIV);

            }



        }



    }

