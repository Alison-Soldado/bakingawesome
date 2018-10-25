package com.example.alissonsoldado.bakingawesome.ui.detail.ingredient;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alissonsoldado.bakingawesome.R;

public class IngredientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textViewQuantity;
    public TextView textViewMeasure;
    public TextView textViewIngredient;
    private IngredientAdapterListener ingredientAdapterListener;

    IngredientViewHolder(View itemView) {
        super(itemView);
        this.textViewQuantity = itemView.findViewById(R.id.item_ingredient_quantity);
        this.textViewMeasure = itemView.findViewById(R.id.item_ingredient_measure);
        this.textViewIngredient = itemView.findViewById(R.id.item_ingredient_ingredient);
        itemView.setOnClickListener(this);
    }

    public void setClickListener(IngredientAdapterListener ingredientAdapterListener) {
        this.ingredientAdapterListener = ingredientAdapterListener;
    }

    @Override
    public void onClick(View v) {
        this.ingredientAdapterListener.onItemClick();
    }
}
