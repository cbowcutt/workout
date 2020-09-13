package com.example.myfirstapp;

import com.example.myfirstapp.models.Exercise;
import com.example.myfirstapp.models.Workout;
import com.example.myfirstapp.models.WorkoutSetUnit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WorkoutTest {

    protected Workout createTestObject() {
        Exercise exercise = new Exercise();
        exercise.isWeighted = true;
        exercise.Name = "Bench Press";
        exercise.UnitType = WorkoutSetUnit.Repetition;
        Workout workout = new Workout();
        workout.exercise = exercise;
        return workout;
    }

    @Test
    public void addSet_isCorrect() {
        Workout workout = createTestObject();
        workout.addSet();
        assertEquals(workout.Set.size(), 1);
        assertEquals(workout.Set.get(0).getWorkoutSetUnit(), WorkoutSetUnit.Repetition);
        assertEquals(workout.Set.get(0).isWeighted(), true);

    }
}