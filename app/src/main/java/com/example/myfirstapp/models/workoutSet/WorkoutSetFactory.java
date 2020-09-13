package com.example.myfirstapp.models.workoutSet;

import com.example.myfirstapp.models.Exercise;

public class WorkoutSetFactory {
    public WorkoutSet createNewSetForExercise(Exercise exercise) {
        return new WorkoutSet(exercise.UnitType, exercise.isWeighted);
    }
}
