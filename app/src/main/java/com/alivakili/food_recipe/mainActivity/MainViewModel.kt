package com.alivakili.food_recipe.mainActivity

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alivakili.a202_2.api.RetrofitClient
import com.alivakili.food_recipe.recipeData.RecipeDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel (private val requestGetRecipeData: CallGetRecipeData?) : ViewModel() {

    private var _state = MutableStateFlow<MainState>(MainState.Loading)
    var state: StateFlow<MainState> = _state



    fun retrieveRecipeData(callGetRecipeData: CallGetRecipeData) {

        var temp=CallGetRecipeDataTemp(
            callGetRecipeData.diet.toTypedArray(),callGetRecipeData.health.toTypedArray(),callGetRecipeData.cuisineType.toTypedArray(),
            callGetRecipeData.mealType.toTypedArray(),callGetRecipeData.dishType.toTypedArray())

        val call = RetrofitClient.ApiClient.apiService.getRecipe(callGetRecipeData.searchText,
            "903328d6",
            "d1a9f80a8356c671f41b4db3ee0e9fb3",
            temp.diet,
            temp.health,
            temp.cuisineType,
            temp.mealType,
            temp.dishType,
        "public")

        if (call != null) {
            call.enqueue(object : Callback<RecipeDTO> {
                override fun onResponse(call: Call<RecipeDTO>, response: Response<RecipeDTO>) {

                    if (response.isSuccessful){
                        _state.value= MainState.Success(response.body())
                    }
                    else{
                        _state.value= MainState.Failure
                    }
                }
                override fun onFailure(call: Call<RecipeDTO>, t: Throwable) {
                    Log.e("TAG", "onResponse: 3"+t.message+t.cause+t.localizedMessage, )
                    _state.value= MainState.Failure
                }
            })
        }

    }


    companion object {
        fun factory(requestGetRecipeData: CallGetRecipeData?): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return MainViewModel(requestGetRecipeData) as T
                }
            }
        }
    }


}