package com.alivakili.food_recipe

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.food_recipe.databinding.IngredientsListItemBinding

class IngredientRecyclerViewAdapter(

    private val context: Context,
    private val items: ArrayList<String>,

    ) : RecyclerView.Adapter<IngredientRecyclerViewAdapter.IngredientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            IngredientViewHolder {
        return IngredientViewHolder.create(parent)
    }


    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val recipe = items.get(position)
        holder.bind(recipe, context)
    }


    override fun getItemCount(): Int {
        return items.size ?: 0
    }

    class IngredientViewHolder(
        private val binding: IngredientsListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun create(parent: ViewGroup): IngredientViewHolder {
                val binding = IngredientsListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return IngredientViewHolder(
                    binding = binding,
                )
            }

        }

        fun bind(recipe: String, context: Context) {

            binding.text.text=recipe


        }


    }


}

