package com.example.myfirstapp.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myfirstapp.R;
import com.example.myfirstapp.viewModels.WorkoutCardViewModel;
import com.example.myfirstapp.viewModels.WorkoutSetViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class WorkoutCardFragment extends Fragment implements View.OnClickListener {
    public WorkoutCardViewModel workoutCardViewModel;
    public ArrayList<WorkoutSetViewModel> workoutSets;
    public LinearLayout workoutSetTableView;



    public interface OnCollapseListener {
        public void onCollapse(View view);
    }

    OnCollapseListener callback;
    WorkoutCardViewModel viewModel;
    View workoutView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        workoutSets = new ArrayList<>();
        // Get the ViewModel.

    }
            // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        workoutView = inflater.inflate(R.layout.workout_card, container, false);
        workoutView.findViewById(R.id.expandCollapse).setOnClickListener(this);
        workoutView.findViewById(R.id.addSetButton).setOnClickListener(this);
        workoutCardViewModel = new ViewModelProvider(this).get(WorkoutCardViewModel.class);
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, a TextView.
                TextInputEditText nameField = (TextInputEditText)workoutView.findViewById(R.id.workoutNameInput);
                nameField.setText(newName);
            }
        };

        TextInputEditText nameField = (TextInputEditText)
                workoutView.findViewById(R.id.workoutNameInput);
        TextWatcher textWatcher = new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!(s.toString().equals(workoutCardViewModel.getWorkoutName().getValue()))) {
                    workoutCardViewModel.setWorkoutName(s.toString());
                }


            }
        };
        nameField.addTextChangedListener(textWatcher);
        workoutCardViewModel.getWorkoutName().observe(getViewLifecycleOwner(), nameObserver);
        this.workoutSetTableView = this.workoutView.findViewById(R.id.workout_set_tableA);
        return workoutView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addSetButton) {
            this.onAddSet(v);
        }
        if (v.getId() == R.id.expandCollapse) {
            this.toggle();
        }
    }

    public void onAddSet(View view) {
        LayoutInflater factory = LayoutInflater.from(this.getContext());
        final View rowView = factory.inflate(R.layout.set_row, null);
        TableLayout table = (TableLayout)this.workoutView.findViewById(R.id.setTable);
        table.addView(rowView);
        this.workoutCardViewModel.addSet();
        final WorkoutSetViewModel newModel = new WorkoutSetViewModel();
        workoutSets.add(newModel);
        newModel.getWeight().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable final Integer newWeight) {
                // Update the UI, in this case, a TextView.
                TextInputEditText weightInput = (TextInputEditText)
                        (rowView.findViewWithTag("set_weight_input"));
                weightInput.setText(newWeight.toString());
            }
        });
        TextInputEditText weightInput = (TextInputEditText)
                (rowView.findViewWithTag("set_weight_input"));
        weightInput.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) { }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Integer currentValue = newModel.getWeight().getValue();
                if ((currentValue == null) || !(s.toString().equals(currentValue.toString()))) {
                    newModel.setWeight(Integer.parseInt(s.toString()));
                }
            }
        });
        newModel.getRepetitions().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable final Integer newRepetitions) {
                // Update the UI, in this case, a TextView.
                TextInputEditText repetitionsInput = (TextInputEditText)
                        (rowView.findViewWithTag("set_repetitions_input"));
                repetitionsInput.setText(newRepetitions.toString());
            }
        });

        TextInputEditText repetitionsInput = (TextInputEditText)
                (rowView.findViewWithTag("set_repetitions_input"));
        repetitionsInput.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) { }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Integer currentValue = newModel.getRepetitions().getValue();
                // TODO: catch empty string
                if ((currentValue == null) || (s.toString().equals("")) ||
                    !(s.toString().equals(currentValue.toString()))) {
                    newModel.setRepetitions(Integer.parseInt(s.toString()));
                }
            }
        });

    }

    public void onSetModified(View view) {

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
