package com.example.alissonsoldado.bakingawesome.ui.detail.step;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alissonsoldado.bakingawesome.R;

public class StepViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private StepItemListener stepItemListener;

    StepViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    void setClickListener(StepItemListener stepItemListener) {
        this.stepItemListener = stepItemListener;
    }

    @Override
    public void onClick(View v) {
        this.stepItemListener.onItemClick();
    }
}

