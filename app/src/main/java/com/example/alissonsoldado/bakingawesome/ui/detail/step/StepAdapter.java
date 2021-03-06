package com.example.alissonsoldado.bakingawesome.ui.detail.step;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Step;

import java.util.ArrayList;

public class StepAdapter extends RecyclerView.Adapter<StepViewHolder> {

    private Context context;
    private ArrayList<Step> steps;
    private StepItemListener stepItemListener;

    StepAdapter(Context context, StepItemListener stepItemListener, ArrayList<Step> steps) {
        this.context = context;
        this.steps = steps;
        this.stepItemListener = stepItemListener;
    }

    @NonNull
    @Override
    public StepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_step, parent, false);
        return new StepViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StepViewHolder holder, int position) {
        holder.textViewCompatNumber.setText(String.valueOf(steps.get(position).getId()));
        holder.textViewCompatShortDescription.setText(steps.get(position).getShortDescription());
        holder.setStep(steps.get(position));
        holder.setClickListener(stepItemListener);
    }

    @Override
    public int getItemCount() {
        return steps == null ? 0 : steps.size();
    }
}
