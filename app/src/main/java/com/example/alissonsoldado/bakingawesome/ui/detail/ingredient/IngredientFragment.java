package com.example.alissonsoldado.bakingawesome.ui.detail.ingredient;

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

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Ingredient;

import java.util.ArrayList;
import java.util.Objects;

public class IngredientFragment extends Fragment {

    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    private RecyclerView recyclerViewIngredients;
    private IngredientAdapter ingredientAdapter;

    public static IngredientFragment newInstance(ArrayList<Ingredient> ingredients) {
        IngredientFragment ingredientFragment = new IngredientFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("ingredients", ingredients);
        ingredientFragment.setArguments(args);
        return ingredientFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ingredients = getArguments().getParcelableArrayList("ingredients");
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
    }

    private void initComponents(View view) {
        recyclerViewIngredients = view.findViewById(R.id.fragment_ingredient_recycler_ingredients);
    }

    private void initInstance() {
        ingredientAdapter = new IngredientAdapter(getContext(), ingredients);
    }
}
