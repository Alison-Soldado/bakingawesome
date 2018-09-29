package com.example.alissonsoldado.bakingawesome.ui.main.recipe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder>{

    private Context context;
    private RecipeAdapterListener recipeAdapterListener;
    private List<Recipe> recipes;

    RecipeAdapter(Context context, RecipeAdapterListener recipeAdapterListener, List<Recipe> recipes) {
        this.context = context;
        this.recipeAdapterListener = recipeAdapterListener;
        this.recipes = recipes;
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
    }

    @Override
    public int getItemCount() {
        return recipes == null ? 0 : recipes.size();
    }

    public void addItems(List<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    public interface RecipeAdapterListener {
        void onItemClick(Recipe recipe);
    }
}
