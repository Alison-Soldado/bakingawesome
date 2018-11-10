package com.example.alissonsoldado.bakingawesome.ui.detail.step;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Step;

import java.util.ArrayList;
import java.util.List;

public class StepFragment extends Fragment implements StepItemListener {

    private List<Step> steps = new ArrayList<>();
    private RecyclerView recyclerViewSteps;
    private StepAdapter stepAdapter;

    public static StepFragment newInstance(List<Step> steps) {
        StepFragment stepFragment = new StepFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("steps", (ArrayList<? extends Parcelable>) steps);
        stepFragment.setArguments(args);
        return stepFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            steps = getArguments().getParcelableArrayList("steps");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step, container, false);
        initComponents(view);
        initInstance();
        return view;
    }

    private void initComponents(View view) {
        recyclerViewSteps = view.findViewById(R.id.fragment_recipe_recycler_recipes);
    }

    private void initInstance() {
//        steps.add(new Step(45645,"sdfsdfsd","dfsa","dfas","afdf"));
        stepAdapter = new StepAdapter(getContext(), this, steps);
    }

    @Override
    public void onItemClick() {

    }
}
