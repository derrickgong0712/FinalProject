package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Analysis extends AppCompatActivity {

    /** weight. */

    private double weight;

    /** height. */
    private double height;

    /** age. */
    private int age;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /** weight. */
        double weight;

        /** height. */
        double height;

        /** age. */
        int age;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        TextView bmi = findViewById(R.id.bmi);
        TextView status = findViewById(R.id.status);
        Intent intent = getIntent();
        weight = intent.getDoubleExtra("weight", 0.0);
        height = intent.getDoubleExtra("height", 0.0);
        age = intent.getIntExtra("age", 0);
        Person person = new Person(weight, height, age);
        Double value = person.getBMI();
        int currentstatus = person.weightstatus(value);
        bmi.setText(value.toString());
        String x = getstatus(currentstatus);
        status.setText(x);
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
}
