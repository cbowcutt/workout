package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        WorkoutCardView workoutView = new WorkoutCardView(this);
        this.exerciseCardContainer().addView(workoutView);
        workoutView.init();
    }

    public void onAddSet(View view) {
        LayoutInflater factory = LayoutInflater.from(this);
        View myView = factory.inflate(R.layout.set_row, null);
        TableLayout table = (TableLayout)this.findViewById(R.id.setTable);
        table.addView(myView);
    }

    public void onCollapse(View view) {
        CollapseExpandButtonView collapseButton = (CollapseExpandButtonView) view;
        collapseButton.toggle();
    }


    public LinearLayout exerciseCardContainer() {
        return (LinearLayout) findViewById(R.id.exerciseCardLayout);
    }

}