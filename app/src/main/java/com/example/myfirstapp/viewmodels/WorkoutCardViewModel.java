package com.example.myfirstapp.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myfirstapp.WorkoutCardView;
import com.example.myfirstapp.models.Workout;
import com.example.myfirstapp.models.workoutSet.WorkoutSet;

import java.util.ArrayList;

public class WorkoutCardViewModel extends ViewModel {

    public Workout workoutModel;
    MutableLiveData<String> workoutName;

    public MutableLiveData<String> getWorkoutName() {
        if (workoutName == null) {
            workoutName = new MutableLiveData<>();
        }
        return workoutName;
    }

    public void setWorkoutName(String name) {
        workoutModel.exercise.Name = name;
        getWorkoutName().postValue(name);
    }

    public WorkoutCardViewModel() {
        super();
        this.workoutModel = new Workout();
    }
    public void addSet() {
        this.workoutModel.addSet();
    }
}