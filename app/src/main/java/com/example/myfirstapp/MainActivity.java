package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.example.myfirstapp.fragments.WorkoutCardFragment;
import com.example.myfirstapp.models.Workout;

public class MainActivity extends AppCompatActivity implements WorkoutCardFragment.OnCollapseListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        getSupportFragmentManager().beginTransaction().add(R.id.exerciseCardLayout, new WorkoutCardFragment(), "workoutCard").commit();
    }
    /**
    public void onAddSet(View view) {
        LayoutInflater factory = LayoutInflater.from(this);
        View myView = factory.inflate(R.layout.set_row, null);
        TableLayout table = (TableLayout)this.findViewById(R.id.s etTable);
        table.addView(myView);
    }
     **/

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof WorkoutCardFragment) {
            WorkoutCardFragment workoutCardFragment = (WorkoutCardFragment) fragment;
        }
    }






    public LinearLayout exerciseCardContainer() {
        return (LinearLayout) findViewById(R.id.exerciseCardLayout);
    }

    @Override
    public void onCollapse(View view) {

    }
}