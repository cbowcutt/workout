package com.example.myfirstapp.viewModels;

import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ExerciseViewModel extends ViewModel {
    public ArrayList<WorkoutCardViewModel> workoutCards;
    public ExerciseViewModel() {
        super();
        this.workoutCards = new ArrayList<WorkoutCardViewModel>();
    }
    public void addWorkout() {

    }
}
