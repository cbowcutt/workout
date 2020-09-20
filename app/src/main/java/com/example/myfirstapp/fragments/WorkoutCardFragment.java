package com.example.myfirstapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.myfirstapp.R;
import com.example.myfirstapp.WorkoutCardView;
import com.example.myfirstapp.viewmodels.WorkoutCardViewModel;

public class WorkoutCardFragment extends Fragment implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        this.toggle();
    }

    public interface OnCollapseListener {
        public void onCollapse(View view);
    }

    OnCollapseListener callback;
    WorkoutCardViewModel viewModel;
    View workoutView;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        workoutView = inflater.inflate(R.layout.workout_card, container, false);
        workoutView.findViewById(R.id.expandCollapse).setOnClickListener(this);
        return workoutView;
    }

    public void onAddSet(View view) {
        LayoutInflater factory = LayoutInflater.from(this.getContext());
        View myView = factory.inflate(R.layout.set_row, null);
        TableLayout table = (TableLayout)view.findViewById(R.id.setTable);
        table.addView(myView);
    }

    public void onCollapseButtonPressed(View view) {
        this.toggle();
    }

    public void setOnCollapseListener(OnCollapseListener callback) {
        this.callback = callback;
    }

    private void toggle() {
        if (this.isCollapsed()) {
            this.expand();
        }
        else {
            this.collapse();
        }
    }

    private boolean isCollapsed() {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) this.workoutView.findViewById(R.id.workout_set_tableA).getLayoutParams();
        if (params.height == 0) {
            return true;
        }
        return false;
    }

    public void collapse() {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) this.workoutView.findViewById(R.id.workout_set_tableA).getLayoutParams();
        params.height = 0;
        this.workoutView.findViewById(R.id.workout_set_tableA).setLayoutParams(params);
    }

    public void expand() {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) this.workoutView.findViewById(R.id.workout_set_tableA).getLayoutParams();
        params.height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        this.workoutView.findViewById(R.id.workout_set_tableA).findViewById(R.id.workout_set_tableA).setLayoutParams(params);
    }

     public void onCollapse(View view) {
        this.toggle();
     }
}
