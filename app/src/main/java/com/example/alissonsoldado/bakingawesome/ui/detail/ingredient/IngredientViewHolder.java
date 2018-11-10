package com.example.alissonsoldado.bakingawesome.ui.detail.ingredient;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alissonsoldado.bakingawesome.R;

public class IngredientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView textViewQuantity;
    TextView textViewMeasure;
    TextView textViewIngredient;
    private IngredientItemListener ingredientAdapterListener;

    IngredientViewHolder(View itemView) {
        super(itemView);
        this.textViewQuantity = itemView.findViewById(R.id.item_ingredient_quantity);
        this.textViewMeasure = itemView.findViewById(R.id.item_ingredient_measure);
        this.textViewIngredient = itemView.findViewById(R.id.item_ingredient_ingredient);
        itemView.setOnClickListener(this);
    }

    void setClickListener(IngredientItemListener ingredientAdapterListener) {
        this.ingredientAdapterListener = ingredientAdapterListener;
    }

    @Override
    public void onClick(View v) {
        this.ingredientAdapterListener.onItemClick();
    }
}
