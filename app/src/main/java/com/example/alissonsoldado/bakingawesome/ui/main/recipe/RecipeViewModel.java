package com.example.alissonsoldado.bakingawesome.ui.main.recipe;

import android.arch.lifecycle.ViewModel;

import com.example.alissonsoldado.bakingawesome.data.model.Recipe;
import com.example.alissonsoldado.bakingawesome.data.model.Resource;
import com.example.alissonsoldado.bakingawesome.data.source.remote.recipe.RecipeRepository;
import com.example.alissonsoldado.bakingawesome.util.SingleLiveEvent;

import java.util.List;

public class RecipeViewModel extends ViewModel {
    public SingleLiveEvent<Resource<List<Recipe>>> bankingSingleLiveEvent = new SingleLiveEvent<>();
    private RecipeRepository recipeRepository = new RecipeRepository();

    void getRecipes() {
        recipeRepository.getRecipe(bankingSingleLiveEvent);
    }

}
