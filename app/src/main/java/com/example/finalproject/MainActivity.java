package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forinputdata = findViewById(R.id.data);
        forinputdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendraftdata();
            }
        });
    }
    public void opendraftdata() {
        Intent intent = new Intent(this, draftdata.class);
        startActivity(intent);
    }
}
