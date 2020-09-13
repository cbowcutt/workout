package com.example.myfirstapp.models;

import java.util.ArrayList;

public class WorkoutRoutine {
    public ArrayList<Workout> workouts;
    public WorkoutRoutine() {
        this.workouts = new ArrayList<Workout>();
    }

    public void addWorkout() {
        this.workouts.add(new Workout());
    }
}

