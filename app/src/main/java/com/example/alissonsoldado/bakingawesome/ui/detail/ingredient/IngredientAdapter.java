package com.example.alissonsoldado.bakingawesome.ui.detail.ingredient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Ingredient;

import java.util.ArrayList;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientViewHolder> {

    private Context context;
    private ArrayList<Ingredient> ingredients;

    IngredientAdapter(Context context, ArrayList<Ingredient> ingredients) {
        this.context = context;
        this.ingredients = ingredients;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ingredient, parent, false);
        return new IngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        holder.textViewQuantity.setText(String.valueOf(ingredients.get(position).getQuantity()));
        holder.textViewMeasure.setText(ingredients.get(position).getMeasure());
        holder.textViewIngredient.setText(ingredients.get(position).getIngredient());
    }

    @Override
    public int getItemCount() {
        return ingredients == null ? 0 : ingredients.size();
    }
}
