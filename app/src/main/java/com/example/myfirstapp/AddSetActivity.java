package com.example.myfirstapp;

import android.bluetooth.le.AdvertisingSet;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;

public class AddSetActivity extends AppCompatActivity {
    private TableLayout parentView;
    AddSetActivity(TableLayout parentTable) {
        this.parentView = parentTable;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater factory = LayoutInflater.from(this);
        View myView = factory.inflate(R.layout.set_row, null);
        this.parentView.addView(myView);
    }
}