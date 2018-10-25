package com.example.alissonsoldado.bakingawesome.ui.detail;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.alissonsoldado.bakingawesome.data.model.Ingredient;
import com.example.alissonsoldado.bakingawesome.data.model.Step;
import com.example.alissonsoldado.bakingawesome.ui.detail.ingredient.IngredientFragment;
import com.example.alissonsoldado.bakingawesome.ui.detail.step.StepFragment;

import java.util.List;

public class DetailAdapter extends FragmentPagerAdapter {

    private List<Step> steps;
    private List<Ingredient> ingredients;

    DetailAdapter(FragmentManager fragmentManager, List<Step> steps, List<Ingredient> ingredients) {
        super(fragmentManager);
        this.steps = steps;
        this.ingredients = ingredients;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return StepFragment.newInstance(steps);
            case 1:
                return IngredientFragment.newInstance(ingredients);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) { return position == 0 ? "Steps" : "Ingredients"; }
}
