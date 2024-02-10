package com.alivakili.food_recipe.mainActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.MenuRes
import androidx.appcompat.widget.PopupMenu
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alivakili.food_recipe.R
import com.alivakili.food_recipe.RecipeActivity
import com.alivakili.food_recipe.databinding.ActivityMainBinding
import com.alivakili.food_recipe.recipeData.RecipeDTO
import com.alivakili.food_recipe.recipeData.SingleRecipe

import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val viewModel: MainViewModel by viewModels {
        MainViewModel.factory(callGetRecipeData)
    }
    private var callGetRecipeData= CallGetRecipeData(
        "",
        "",
        "", ArrayList(),
        ArrayList(),
        ArrayList(),
        ArrayList() ,
        ArrayList()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureToolbar(title = "Delicious")
        checkEditText()
        observeState()
        checkDropDownMenu()
    }

    private fun showMenu(v: View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(this, v)
        popup.menuInflater.inflate(menuRes, popup.menu)

        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
            binding.categoryNameTV.text=menuItem.toString()
            when (menuRes) {

                R.menu.diet_menu -> {
                 callGetRecipeData?.diet?.add(menuItem.title.toString().lowercase())

                }
                R.menu.meal_menu -> {
                    callGetRecipeData?.mealType?.add(menuItem.title.toString().lowercase())
                }
                R.menu.cuisine_menu -> {
                    callGetRecipeData?.cuisineType?.add(menuItem.title.toString().lowercase())
                }
                R.menu.health_menu -> {
                    callGetRecipeData?.health?.add(menuItem.title.toString().lowercase())
                }
                R.menu.dish_menu -> {
                    callGetRecipeData?.dishType?.add(menuItem.title.toString().lowercase())
                }
            }
            getRecipes()
            true
        }
        popup.setOnDismissListener {
            // Respond to popup being dismissed.
        }
        // Show the popup menu.
        popup.show()
    }

    private fun checkDropDownMenu() {
        binding.dietBtn.setOnClickListener {
            showMenu(it, R.menu.diet_menu)
        }
        binding.dishBtn.setOnClickListener {
            showMenu(it, R.menu.dish_menu)
        }
        binding.cuisineBtn.setOnClickListener {
            showMenu(it, R.menu.cuisine_menu)
        }
        binding.mealBtn.setOnClickListener {
            showMenu(it, R.menu.meal_menu)
        }
        binding.healthBtn.setOnClickListener {
            showMenu(it, R.menu.health_menu)
        }


    }

    private fun configureToolbar(title: String) {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            this.title = title
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.state.collect { state ->
                    when (state) {
                        MainState.Loading -> hideProgressBar()
                        is MainState.Success -> {
                            showRecipes(state.recipeDOT)
                        }

                        MainState.Failure -> showErrorMessage()
                    }
                }
            }
        }
    }

    private fun showRecipes(recipeDOT: RecipeDTO?) {
        binding.recyclerView.apply {
            adapter = RecipeRecyclerViewAdapter(
                items = recipeDOT, onClicked = ::showRecipeActivity,
                context = this@MainActivity
            )
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            visibility = View.VISIBLE
        }
    }

    private fun showRecipeActivity(recipe: SingleRecipe) {
        val intent = Intent(this@MainActivity, RecipeActivity::class.java)

        intent.putExtra("KEY_RECIPE",recipe)
        startActivity(intent)

    }

    private fun showErrorMessage() {
        Toast.makeText(this, "Unable to retrieve data!", Toast.LENGTH_LONG).show()
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun checkEditText() {

        binding.searchRecipeET.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                callGetRecipeData?.searchText = s.toString()
                binding.categoryNameTV.text=s.toString()
                getRecipes()
            }
        })

    }

    private fun getRecipes() {
        viewModel.retrieveRecipeData(callGetRecipeData)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.state.collect { state ->
                    when (state) {
                        MainState.Loading -> showProgressBar()
                        is MainState.Success -> {
                            hideProgressBar()
                            showRecipes(state.recipeDOT)
                        }

                        MainState.Failure -> {
                            hideProgressBar()
                        }
                    }
                }
            }
        }
    }
}