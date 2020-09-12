package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        LayoutInflater factory = LayoutInflater.from(this);
        View myView = factory.inflate(R.layout.workout_card, null);
        this.exerciseCardContainer().addView(myView);
    }

    public void onAddSet(View view) {
        LayoutInflater factory = LayoutInflater.from(this);
        View myView = factory.inflate(R.layout.set_row, null);
        TableLayout table = (TableLayout)this.findViewById(R.id.setTable);
        table.addView(myView);
    }

    public void onCollapse(View view) {
        // collapse the view
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) findViewById(R.id.workout_set_tableA).getLayoutParams();
        params.height = 0;
        findViewById(R.id.workout_set_tableA).setLayoutParams(params);
    }


    public LinearLayout exerciseCardContainer() {
        return (LinearLayout) findViewById(R.id.exerciseCardLayout);
    }
}