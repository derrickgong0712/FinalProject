package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Analysis extends AppCompatActivity {

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
        setContentView(R.layout.activity_analysis);
        TextView bmi = findViewById(R.id.bmi);
        TextView status = findViewById(R.id.status);
        Intent intent = getIntent();
        weight = intent.getDoubleExtra("weight", 0.0);
        height = intent.getDoubleExtra("height", 0.0);
        age = intent.getIntExtra("age", 0);
        Person person = new Person(weight, height, age);
        value = person.getBMI();
        int currentstatus = person.weightstatus(value);
        Double shortervalue = roundDown5(value);
        bmi.setText(shortervalue.toString());
        String x = getstatus(currentstatus);
        status.setText(x);
        Button plan = findViewById(R.id.startplan);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openplan();
            }
        });
    }

    private String getstatus(int x) {
        String a = "Obese";
        if (x == 0) {
            a = "UnderWeight";
        } else if (x == 1) {
            a = "Normal or Healthy Weight";
        } else if (x == 2) {
            a = "Overweight";
        }
        return a;
    }

    public static double roundDown5(double number) {
        return ((long)(number * 1e5)) / 1e5;
    }

    private void openplan() {
        Intent intent = new Intent(this, Plan.class);
        intent.putExtra("bmi", value);
        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        intent.putExtra("age", age);
        startActivity(intent);
        finish();
    }


}
