package com.example.alissonsoldado.bakingawesome.ui.main.recipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Recipe;

public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textViewName;
    private RecipeAdapterListener recipeAdapterListener;
    private Recipe recipe;

    RecipeViewHolder(View itemView) {
        super(itemView);
        this.textViewName = itemView.findViewById(R.id.item_recipe_name);
        itemView.setOnClickListener(this);
    }

    public void setClickListener(RecipeAdapterListener recipeAdapterListener){
        this.recipeAdapterListener = recipeAdapterListener;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public void onClick(View v) {
        this.recipeAdapterListener.onItemClick(recipe);
    }
}
