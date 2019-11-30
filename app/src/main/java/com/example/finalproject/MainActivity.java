package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private double weight;
    private double height;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button forinputdata = findViewById(R.id.data);
        Button forstart = findViewById(R.id.start);
        Intent intent = getIntent();
        weight = intent.getDoubleExtra("weight", 0.0);
        height = intent.getDoubleExtra("height", 0.0);
        age = intent.getIntExtra("age", 0);
        forinputdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendraftdata();
            }
        });
        forstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAnalysis();
            }
        });
    }
    public void opendraftdata() {
        Intent intent = new Intent(this, Draftdata.class);
        startActivity(intent);
    }
    public void openAnalysis() {
        Intent analysisintent = new Intent(this, Analysis.class);
        analysisintent.putExtra("height", height);
        analysisintent.putExtra("weight", weight);
        analysisintent.putExtra("age", age);
        startActivity(analysisintent);
    }
}

