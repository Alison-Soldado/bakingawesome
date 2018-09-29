package com.example.alissonsoldado.bakingawesome.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.alissonsoldado.bakingawesome.data.model.Recipe;

import java.util.List;

public class Recipes implements Parcelable {

    private List<Recipe> recipes;


    protected Recipes(Parcel in) {
        recipes = in.createTypedArrayList(Recipe.CREATOR);
    }

    public static final Creator<Recipes> CREATOR = new Creator<Recipes>() {
        @Override
        public Recipes createFromParcel(Parcel in) {
            return new Recipes(in);
        }

        @Override
        public Recipes[] newArray(int size) {
            return new Recipes[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(recipes);
    }
}
