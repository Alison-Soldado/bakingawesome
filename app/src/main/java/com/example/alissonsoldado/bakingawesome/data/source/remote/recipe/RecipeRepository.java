package com.example.alissonsoldado.bakingawesome.data.source.remote.recipe;

import android.support.annotation.NonNull;

import com.example.alissonsoldado.bakingawesome.data.model.Recipe;
import com.example.alissonsoldado.bakingawesome.data.model.Resource;
import com.example.alissonsoldado.bakingawesome.data.source.remote.Api;
import com.example.alissonsoldado.bakingawesome.data.source.remote.WebService;
import com.example.alissonsoldado.bakingawesome.util.SingleLiveEvent;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeRepository {

    private WebService webService = new Api().getBankingService();

    public void getRecipe(SingleLiveEvent<Resource<List<Recipe>>> bankingSingleLiveEvent) {
        webService.getRecipe().enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(@NonNull Call<List<Recipe>> call, @NonNull Response<List<Recipe>> response) {
                bankingSingleLiveEvent.setValue(Resource.success(Objects.requireNonNull(response.body())));
            }

            @Override
            public void onFailure(@NonNull Call<List<Recipe>> call, @NonNull Throwable t) {
                bankingSingleLiveEvent.setValue(Resource.error(t.getMessage(), null));
            }
        });
    }
}
