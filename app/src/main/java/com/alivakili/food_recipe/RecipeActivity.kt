package com.alivakili.food_recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.alivakili.food_recipe.databinding.ActivityRecipeBinding
import com.alivakili.food_recipe.recipeData.SingleRecipe
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import jp.wasabeef.glide.transformations.BlurTransformation

class RecipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeBinding
    private lateinit var recipe: SingleRecipe
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recipe = getRecipeFromIntent()
        showRecipe(recipe)
        configureToolbar(title = recipe.foodName)


    }

    private fun configureToolbar(title: String) {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            this.title = title
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.back_arrow)
        }
    }


    private fun getRecipeFromIntent(): SingleRecipe {
        return intent.getParcelableExtra<SingleRecipe>("KEY_RECIPE")!!
    }


    private fun bluredImage(imageView: ImageView, item: String) {
        Glide.with(this)
            .load(recipe.imageUrl)
            .apply(bitmapTransform(BlurTransformation(50, 3)))
            .into(imageView)
    }

    private fun loadImage(imageView: ImageView, item: String) {
        Glide.with(this)
            .load(recipe.imageUrl)
            .into(imageView)
    }

    private fun showRecipe(recipe: SingleRecipe) {
        binding.caloriesTV.text = recipe.calories.toString()
        binding.totalTimeTV.text = recipe.totalTime
        loadImage(binding.mainIV, recipe.imageUrl)
        bluredImage(binding.bluredIV, recipe.imageUrl)

        binding.recyclerView.apply {
            adapter = IngredientRecyclerViewAdapter(
                items = recipe.ingredients,
                context = this@RecipeActivity
            )
            layoutManager = LinearLayoutManager(this@RecipeActivity)
            setHasFixedSize(true)
            visibility = View.VISIBLE
        }
    }

}



