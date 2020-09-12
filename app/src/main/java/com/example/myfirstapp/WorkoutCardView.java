package com.example.myfirstapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

/**
 * TODO: document your custom view class.
 */
public class WorkoutCardView extends CardView {
    public WorkoutCardView(@NonNull Context context) {
        super(context);
    }
    public WorkoutCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WorkoutCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public void init() {
        inflate(getContext(), R.layout.workout_card, this);
        this.getCollapseButton().setCollapsableView(this.getWorkoutSetView());
    }

    public CollapseButtonView getCollapseButton() {
        return this.findViewById(R.id.expandCollapse);
    }

    public View getWorkoutSetView() {
        return this.findViewById(R.id.workout_set_tableA);
    }
}
