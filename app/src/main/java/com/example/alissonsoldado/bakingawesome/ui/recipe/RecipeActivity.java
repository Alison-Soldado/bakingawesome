package com.example.alissonsoldado.bakingawesome.ui.recipe;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Recipe;
import com.example.alissonsoldado.bakingawesome.ui.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecipeActivity extends AppCompatActivity implements RecipeAdapterListener {

    private RecyclerView recyclerViewRecipes;
    private ProgressBar progressBarRecipes;
    private RecipeViewModel recipeViewModel;
    private RecipeAdapter recipeAdapter;
    private List<Recipe> recipes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        initComponent();
        initInstance();
        setupRecyclerView();
        getListRecipes();
        initObservers();
    }

    private void initComponent() {
        recyclerViewRecipes = findViewById(R.id.activity_recipe_recycler_recipes);
        progressBarRecipes = findViewById(R.id.activity_recipe_progress_recipes);
    }

    private void initInstance() {
        recipeViewModel = ViewModelProviders.of(this).get(RecipeViewModel.class);
        recipeAdapter = new RecipeAdapter(this, this, recipes);
    }

    private void getListRecipes() {
        progressBarRecipes.setVisibility(View.VISIBLE);
        recyclerViewRecipes.setVisibility(View.GONE);
        recipeViewModel.getRecipes();
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewRecipes.setLayoutManager(linearLayoutManager);
        DividerItemDecoration itemDecoration =
                new DividerItemDecoration(Objects.requireNonNull(this), DividerItemDecoration.VERTICAL);
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
        Intent intentDetail = new Intent(this, DetailActivity.class);
        intentDetail.putExtra("recipe", recipe);
        startActivity(intentDetail);
    }
}
