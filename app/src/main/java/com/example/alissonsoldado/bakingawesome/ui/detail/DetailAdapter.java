package com.example.alissonsoldado.bakingawesome.ui.detail;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.alissonsoldado.bakingawesome.data.model.Recipe;
import com.example.alissonsoldado.bakingawesome.ui.detail.ingredient.IngredientFragment;
import com.example.alissonsoldado.bakingawesome.ui.detail.step.StepFragment;

public class DetailAdapter extends FragmentPagerAdapter {

    private Recipe recipe;

    DetailAdapter(FragmentManager fragmentManager, Recipe recipe) {
        super(fragmentManager);
        this.recipe = recipe;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return StepFragment.newInstance(recipe.getSteps());
            case 1:
                return IngredientFragment.newInstance(recipe.getIngredients());
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
