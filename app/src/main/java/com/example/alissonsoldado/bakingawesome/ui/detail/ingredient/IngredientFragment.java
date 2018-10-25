package com.example.alissonsoldado.bakingawesome.ui.detail.ingredient;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IngredientFragment extends Fragment implements IngredientAdapterListener {

    private List<Ingredient> ingredients = new ArrayList<>();
    private RecyclerView recyclerViewIngredients;
    private IngredientAdapter ingredientAdapter;

    public static IngredientFragment newInstance(List<Ingredient> ingredients) {
        IngredientFragment ingredientFragment = new IngredientFragment();
        Bundle args = new Bundle();
        args.putParcelable("ingredients", (Parcelable) ingredients);
        ingredientFragment.setArguments(args);
        return ingredientFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ingredients = getArguments().getParcelable("ingredients");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingredient, container, false);
        initComponents(view);
        initInstance();
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewIngredients.setLayoutManager(linearLayoutManager);
        DividerItemDecoration itemDecoration =
                new DividerItemDecoration(Objects.requireNonNull(getContext()), DividerItemDecoration.VERTICAL);
        recyclerViewIngredients.addItemDecoration(itemDecoration);
        recyclerViewIngredients.setHasFixedSize(true);
        recyclerViewIngredients.setAdapter(ingredientAdapter);
        recyclerViewIngredients.getAdapter().notifyDataSetChanged();
    }

    private void initInstance() {
        ingredientAdapter = new IngredientAdapter(getContext(), this, ingredients);
    }

    private void initComponents(View view) {
        recyclerViewIngredients = view.findViewById(R.id.fragment_ingredient_ingredients);
    }

    @Override
    public void onItemClick() {

    }
}
