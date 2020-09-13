package com.example.myfirstapp;

import com.example.myfirstapp.fixtures.TestFixtures;
import com.example.myfirstapp.models.Exercise;
import com.example.myfirstapp.models.Workout;
import com.example.myfirstapp.models.WorkoutRoutine;
import com.example.myfirstapp.models.WorkoutSetUnit;
import com.example.myfirstapp.models.workoutSet.WorkoutSet;

import org.junit.Test;

import static org.junit.Assert.*;
public class WorkoutRoutineTest {

    @Test
    public void addWorkout_isCorrect() {
        WorkoutRoutine routine = TestFixtures.createWorkoutRoutineTestObject();
        routine.addWorkout();
        assertEquals(1, routine.workouts.size());
    }
}
