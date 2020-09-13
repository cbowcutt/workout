package com.example.myfirstapp.fixtures;

import com.example.myfirstapp.models.Exercise;
import com.example.myfirstapp.models.Workout;
import com.example.myfirstapp.models.WorkoutRoutine;
import com.example.myfirstapp.models.WorkoutSetUnit;
import com.example.myfirstapp.models.workoutSet.WorkoutSet;

public class TestFixtures {
    public static WorkoutSet createWorkoutSetTestObject() {
        return new WorkoutSet(WorkoutSetUnit.Repetition, true);
    }

    public static WorkoutRoutine createWorkoutRoutineTestObject() {
        return new WorkoutRoutine();
    }

    public static Exercise createExerciseTestObject() {
        Exercise exercise = new Exercise();
        exercise.isWeighted = true;
        exercise.Name = "Bench Press";
        exercise.UnitType = WorkoutSetUnit.Repetition;
        return exercise;
    }

    public static Workout createWorkoutTestObject() {

        Workout workout = new Workout();
        workout.exercise = TestFixtures.createExerciseTestObject();
        return workout;
    }
}
