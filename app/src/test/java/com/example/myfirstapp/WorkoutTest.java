package com.example.myfirstapp;

import com.example.myfirstapp.fixtures.TestFixtures;
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
    @Test
    public void addSet_isCorrect() {
        Workout workout = TestFixtures.createWorkoutTestObject();
        workout.addSet();
        assertEquals(workout.Set.size(), 1);
        assertEquals(workout.Set.get(0).getWorkoutSetUnit(), WorkoutSetUnit.Repetition);
        assertEquals(workout.Set.get(0).isWeighted(), true);

    }
}