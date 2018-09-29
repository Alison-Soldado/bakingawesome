package com.example.alissonsoldado.bakingawesome.ui.main.recipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alissonsoldado.bakingawesome.R;

public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textViewName;
    //TODO: Analisar a possibilidade de implementação do click aqui
    private RecipeAdapterListener recipeAdapterListener;

    RecipeViewHolder(View itemView) {
        super(itemView);
        this.textViewName = itemView.findViewById(R.id.item_recipe_name);
    }

    @Override
    public void onClick(View v) {
        v.setOnClickListener(this);
    }
}
