package com.example.alissonsoldado.bakingawesome.ui.recipe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private Context context;
    private List<Recipe> recipes;
    private RecipeAdapterListener recipeAdapterListener;

    RecipeAdapter(Context context, RecipeAdapterListener recipeAdapterListener, List<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
        this.recipeAdapterListener = recipeAdapterListener;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recipe, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.textViewName.setText(recipes.get(position).getName());
        holder.setClickListener(recipeAdapterListener);
        holder.setRecipe(recipes.get(position));
    }

    @Override
    public int getItemCount() {
        return recipes == null ? 0 : recipes.size();
    }

    void addItems(List<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }
}
