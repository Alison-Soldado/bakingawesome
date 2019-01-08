package com.example.alissonsoldado.bakingawesome.ui.detail.step;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Step;

public class StepViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    AppCompatTextView textViewCompatNumber;
    AppCompatTextView textViewCompatShortDescription;
    private Step step;
    private StepItemListener stepItemListener;

    StepViewHolder(View itemView) {
        super(itemView);
        this.textViewCompatNumber = itemView.findViewById(R.id.item_step_number);
        this.textViewCompatShortDescription = itemView.findViewById(R.id.item_step_shortDescription);
        itemView.setOnClickListener(this);
    }

    void setStep(Step step) {
        this.step = step;
    }

    void setClickListener(StepItemListener stepItemListener) {
        this.stepItemListener = stepItemListener;
    }

    @Override
    public void onClick(View v) {
        this.stepItemListener.onItemClick(step);
    }
}

