package com.example.alissonsoldado.bakingawesome.ui.detail.step;

import android.content.Intent;
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
import android.widget.Toast;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Step;

import java.util.ArrayList;
import java.util.Objects;

public class StepFragment extends Fragment implements StepItemListener {

    private ArrayList<Step> steps = new ArrayList<>();
    private RecyclerView recyclerViewSteps;
    private StepAdapter stepAdapter;

    public static StepFragment newInstance(ArrayList<Step> steps) {
        StepFragment stepFragment = new StepFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("steps", steps);
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
        setupRecyclerView();
        return view;
    }

    private void initComponents(View view) {
        recyclerViewSteps = view.findViewById(R.id.fragment_step_steps);
    }

    private void initInstance() {
        stepAdapter = new StepAdapter(getContext(), this, steps);
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewSteps.setLayoutManager(linearLayoutManager);
        DividerItemDecoration itemDecoration =
                new DividerItemDecoration(Objects.requireNonNull(getContext()), DividerItemDecoration.VERTICAL);
        recyclerViewSteps.addItemDecoration(itemDecoration);
        recyclerViewSteps.setHasFixedSize(true);
        recyclerViewSteps.setAdapter(stepAdapter);
    }

    @Override
    public void onItemClick(Step step) {
        Intent intentStepDetail = new Intent(getContext(), DetailStepActivity.class);
        intentStepDetail.putExtra("step", step);
        startActivity(intentStepDetail);
    }
}
