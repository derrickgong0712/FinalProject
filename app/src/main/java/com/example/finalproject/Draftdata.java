package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Draftdata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draftdata);
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        textView1.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        textView3.setVisibility(View.VISIBLE);
        Button complete = findViewById(R.id.button4);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMainActivity();
            }
        });
    }

    private void openMainActivity() {
        Intent intent = new Intent(this, Analysis.class);
        EditText height = findViewById(R.id.height);
        EditText weight = findViewById(R.id.weight);
        EditText age = findViewById(R.id.age);
        String theheight = height.getText().toString();
        double realheight = Double.parseDouble(theheight);
        String theweight = weight.getText().toString();
        double realweight = Double.parseDouble(theweight);
        String theage = age.getText().toString();
        int realage = Integer.parseInt(theage);
        intent.putExtra("height", realheight);
        intent.putExtra("weight", realweight);
        intent.putExtra("age", realage);
        startActivity(intent);
        finish();
    }
}
