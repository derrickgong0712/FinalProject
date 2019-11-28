package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class draftdata extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draftdata);
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
        storedata();
    }
    private void storedata(){
        EditText height = findViewById(R.id.height);
        EditText weight = findViewById(R.id.weight);
        String theheight = height.getText().toString();
        double realheight = Double.parseDouble(theheight);
        String theweight = weight.getText().toString();
        double realweight = Double.parseDouble(theweight);
        Intent intent = getIntent();
        intent.putExtra("height", realheight);
        intent.putExtra("weight", realweight);
    }
    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

