package com.example.alissonsoldado.bakingawesome.ui.detail.step;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Step;

import java.util.ArrayList;
import java.util.List;

public class StepFragment extends Fragment {

    private List<Step> steps = new ArrayList<>();

    public static StepFragment newInstance(List<Step> steps) {
        StepFragment stepFragment = new StepFragment();
        Bundle args = new Bundle();
        args.putParcelable("steps", (Parcelable) steps);
        stepFragment.setArguments(args);
        return stepFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            steps = getArguments().getParcelable("steps");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step, container, false);
        return view;
    }
}
