package com.example.myfirstapp;

import android.bluetooth.le.AdvertisingSet;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.myfirstapp.R.layout.workout_card;

public class CreateWorkoutActivity extends AppCompatActivity {
    private LinearLayout parentView;
    CreateWorkoutActivity(LinearLayout _parentView) {
        this.parentView = _parentView;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater factory = LayoutInflater.from(this);
        View myView = factory.inflate(R.layout.workout_card, null);
        this.parentView.addView(myView);
    }

    public void onAddSet(View view) {
        AddSetActivity addSetActivity = new AddSetActivity((TableLayout)findViewById(R.id.setTable));
    }

}


