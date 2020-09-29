package com.example.myfirstapp.fragments;

import androidx.fragment.app.Fragment;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.myfirstapp.MainActivity;
import com.example.myfirstapp.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.fail;


@RunWith(AndroidJUnit4.class)
public class WorkoutCardFragmentTest {
    public ActivityScenario scenario;
    @Before
    public void setup() {
        scenario = ActivityScenario.launch(MainActivity.class);
    }
    private void doTest(ActivityScenario.ActivityAction activity) {
        ActivityScenario scenario = ActivityScenario.launch(MainActivity.class);
        scenario.onActivity(activity);
        scenario.recreate();
    }
    @Test
    public void test_workoutCardFragment_create() {
        doTest(new ActivityScenario.ActivityAction<MainActivity>() {
            @Override
            public void perform(MainActivity Activity) {
                assert(Activity.getSupportFragmentManager().getFragments().size() == 0);
                Activity.sendMessage(Activity.exerciseCardContainer());
                List<Fragment> f = Activity.getSupportFragmentManager().getFragments();
                assert(f.size() == 1);
                //fail("pending");
            }
        });
    }
    @Test
    public void test_workoutCardFragment_workoutSetsSizeSameAsWorkoutModelSetSize() {
        doTest(new ActivityScenario.ActivityAction<MainActivity>() {
            @Override
            public void perform(MainActivity Activity) {
                Activity.sendMessage(Activity.exerciseCardContainer());
                Fragment f = Activity.getSupportFragmentManager().getFragments().get(0);
                WorkoutCardFragment fragment = (WorkoutCardFragment) f;
                assert(fragment.workoutSets.size() == fragment.workoutCardViewModel.workoutModel.Set.size());
            }
        });
    }
    @Test
    public void test_workoutCardFragment_addSet() {
        doTest(new ActivityScenario.ActivityAction<MainActivity>() {
            @Override
            public void perform(MainActivity Activity) {
                Activity.sendMessage(Activity.exerciseCardContainer());
                Fragment f = Activity.getSupportFragmentManager().getFragments().get(0);
                WorkoutCardFragment fragment = (WorkoutCardFragment) f;
                fragment.onClick(f.getView().findViewById(R.id.addSetButton));
                assert(fragment.workoutSets.size() == fragment.workoutCardViewModel.workoutModel.Set.size());
            }
        });
    }
    @Test
    public void test_workoutCardFragment_setWeightValue() {
        doTest(new ActivityScenario.ActivityAction<MainActivity>() {
            @Override
            public void perform(MainActivity Activity) {
                Activity.sendMessage(Activity.exerciseCardContainer());
                Fragment f = Activity.getSupportFragmentManager().getFragments().get(0);
                WorkoutCardFragment fragment = (WorkoutCardFragment) f;
                fragment.onClick(f.getView().findViewById(R.id.addSetButton));
                // TODO: finish
                fail("todo");
            }
        });
    }
}
