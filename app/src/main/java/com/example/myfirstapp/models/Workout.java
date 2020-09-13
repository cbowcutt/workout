package com.example.myfirstapp.models;

import com.example.myfirstapp.models.workoutSet.WorkoutSet;
import com.example.myfirstapp.models.workoutSet.WorkoutSetFactory;

import java.util.ArrayList;

public class Workout {
    public Exercise exercise;
    public ArrayList<WorkoutSet> Set;

    public Workout() {
        this.Set = new ArrayList<WorkoutSet>();
    }

    public void addSet() {
        this.Set.add(new WorkoutSetFactory().createNewSetForExercise(this.exercise));
    }
}
