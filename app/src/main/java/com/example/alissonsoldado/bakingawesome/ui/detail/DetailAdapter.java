package com.example.alissonsoldado.bakingawesome.ui.detail;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.alissonsoldado.bakingawesome.ui.detail.ingredient.IngredientFragment;
import com.example.alissonsoldado.bakingawesome.ui.detail.step.StepFragment;

public class DetailAdapter extends FragmentPagerAdapter {

    DetailAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new IngredientFragment();
            case 1:
                return new StepFragment();
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
    public CharSequence getPageTitle(int position) { return position == 0 ? "Ingredients" : "Steps"; }
}
