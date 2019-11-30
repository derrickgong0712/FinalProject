package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Plan extends AppCompatActivity {
    /** weight. */

    private double weight;

    /** height. */
    private double height;

    /** age. */
    private int age;

    /** bmi. */
    Double value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        Intent intent = getIntent();
        weight = intent.getDoubleExtra("weight", 0.0);
        height = intent.getDoubleExtra("height", 0.0);
        age = intent.getIntExtra("age", 0);
        value = intent.getDoubleExtra("value", 0.0);
        Button myplan = findViewById(R.id.myplan);
        Button bestplan = findViewById(R.id.bestplan);
        myplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmyplan();
            }
        });
        bestplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbestplan();
            }
        });
    }

    private void openmyplan() {
        Intent intent = new Intent(this, Myplan.class);
        intent.putExtra("bmi", value);
        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        intent.putExtra("age", age);
        startActivity(intent);
        finish();
    }

    private void openbestplan() {
        Intent intent = new Intent(this, Bestplan.class);
        intent.putExtra("bmi", value);
        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        intent.putExtra("age", age);
        startActivity(intent);
        finish();
    }

}
