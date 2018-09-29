package com.example.alissonsoldado.bakingawesome.ui.recipe;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecipeFragment extends Fragment implements RecipeAdapter.RecipeAdapterListener {

    private RecyclerView recyclerViewRecipes;
    private ProgressBar progressBarRecipes;
    private RecipeViewModel recipeViewModel;
    private RecipeAdapter recipeAdapter;
    private List<Recipe> recipes = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);
        initComponent(view);
        initInstance();
        getListRecipes();
        setupRecyclerView();
        initObservers();
        return view;
    }

    private void initComponent(View view) {
        recyclerViewRecipes = view.findViewById(R.id.fragment_recipe_recycler_recipes);
        progressBarRecipes = view.findViewById(R.id.fragment_recipe_progress_recipes);
    }

    private void initInstance() {
        recipeViewModel = ViewModelProviders.of(this).get(RecipeViewModel.class);
        recipeAdapter = new RecipeAdapter(getContext(), this, recipes);
    }

    private void getListRecipes() {
        progressBarRecipes.setVisibility(View.VISIBLE);
        recyclerViewRecipes.setVisibility(View.GONE);
        recipeViewModel.getRecipes();
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewRecipes.setLayoutManager(linearLayoutManager);
        DividerItemDecoration itemDecoration =
                new DividerItemDecoration(Objects.requireNonNull(getContext()), DividerItemDecoration.VERTICAL);
        recyclerViewRecipes.addItemDecoration(itemDecoration);
        recyclerViewRecipes.setHasFixedSize(true);
        recyclerViewRecipes.setAdapter(recipeAdapter);
    }

    private void initObservers() {
        recipeViewModel.bankingSingleLiveEvent.observe(this, recipe -> {
            if (recipe != null) {
                recipeAdapter.addItems(recipe.data);
                progressBarRecipes.setVisibility(View.GONE);
                recyclerViewRecipes.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onItemClick(Recipe recipe) {

    }
}
