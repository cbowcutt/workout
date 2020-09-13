package com.example.myfirstapp;

import com.example.myfirstapp.models.Exercise;
import com.example.myfirstapp.models.Workout;
import com.example.myfirstapp.models.WorkoutSetUnit;
import com.example.myfirstapp.models.workoutSet.WorkoutSet;

import org.junit.Test;

import static org.junit.Assert.*;
public class WorkoutSetTest {
    public WorkoutSet createTestObject() {
        return new WorkoutSet(WorkoutSetUnit.Repetition, true);
    }

    @Test
    public void setGoal_isCorrect() throws Exception {
        WorkoutSet workoutSet = createTestObject();
        workoutSet.setGoal(1);
        assertEquals(workoutSet.getGoal(), 1);
    }

    @Test
    public void setGoal_doesNotAllowNegativeNumbers() {
        WorkoutSet workoutSet = createTestObject();
        try {
            workoutSet.setGoal(-11);
        }
        catch (Exception e) {
            assertTrue(e.getMessage().equals("Negative values not allowed for WorkoutSet.goal"));
            return;
        }
        fail("no execption thrown");
    }

    @Test
    public void isCompleted_returnsTrueifUnitsCompletedEqualsGoal() throws Exception {
        WorkoutSet workoutSet = createTestObject();
        workoutSet.setGoal(10);
        workoutSet.setUnitsCompletedTowardGoal(10);
        assertTrue(workoutSet.isCompleted());
    }
    @Test
    public void isCompleted_returnsTrueifUnitsCompletedGreaterThanGoal() throws Exception {
        WorkoutSet workoutSet = createTestObject();
        workoutSet.setGoal(10);
        workoutSet.setUnitsCompletedTowardGoal(11);
        assertTrue(workoutSet.isCompleted());
    }

    @Test
    public void isCompleted_returnsTrueifUnitsLessThanGoal() throws Exception {
        WorkoutSet workoutSet = createTestObject();
        workoutSet.setGoal(10);
        workoutSet.setUnitsCompletedTowardGoal(9);
        assertFalse(workoutSet.isCompleted());
    }

    @Test
    public void getUnitsCompletedTowardGoal_isCorrect() {
        WorkoutSet workoutSet = createTestObject();
        workoutSet.setUnitsCompletedTowardGoal(9);
        assertEquals(9, workoutSet.getUnitsCompletedTowardGoal());
    }

}
