package com.example.alissonsoldado.bakingawesome.ui.recipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alissonsoldado.bakingawesome.R;

public class RecipeViewHolder extends RecyclerView.ViewHolder {

    public TextView textViewName;

    RecipeViewHolder(View itemView) {
        super(itemView);
        this.textViewName = itemView.findViewById(R.id.item_recipe_name);
    }
}
