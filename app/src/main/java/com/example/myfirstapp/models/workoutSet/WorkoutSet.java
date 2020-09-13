package com.example.myfirstapp.models.workoutSet;


import com.example.myfirstapp.models.WorkoutSetUnit;

public class WorkoutSet {
    private WorkoutSetUnit workoutSetUnit;
    private int goal;
    private int unitsCompletedTowardGoal;

    private boolean isWeighted;
    public WorkoutSet(WorkoutSetUnit workoutSetUnit, boolean isWeighted) {
        this.workoutSetUnit = workoutSetUnit;
        this.unitsCompletedTowardGoal = 0;
        this.isWeighted = isWeighted;
    }

    public WorkoutSetUnit getWorkoutSetUnit() {
        return this.workoutSetUnit;
    }

    public void setGoal(int value) throws Exception {
        if (value < 0) {
            throw new Exception("Negative values not allowed for WorkoutSet.goal");
        }
        this.goal = value;

    }

    public int getGoal() { return this.goal; }

    public int getUnitsCompletedTowardGoal() {
        return this.unitsCompletedTowardGoal;
    }

    public void setUnitsCompletedTowardGoal(int value) {
        this.unitsCompletedTowardGoal = value;
    }

    public boolean isWeighted() {
        return this.isWeighted;
    }

    public boolean isCompleted() {
        return this.unitsCompletedTowardGoal >= this.goal;
    }


}
