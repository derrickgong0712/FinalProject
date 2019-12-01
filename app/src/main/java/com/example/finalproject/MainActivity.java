package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    /* this is for Firebase.*/
    private FirebaseAuth mAuth;
    /* this is for the gameactivity.*/
    private Intent intent;
    /* this is for the edittext.*/
    EditText foremail;
    /* this is for another edittext.*/
    EditText forpassword;
    /* this is for the checkbox.*/
    CheckBox showpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, NewMainActivity.class);
        Button signup = findViewById(R.id.button2);
        Button forlogin = findViewById(R.id.login);
        signup.setVisibility(View.VISIBLE);
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTosignup();
            }
        });
        forlogin.setOnClickListener(v -> {
            startActivity(intent);
        });
        foremail = findViewById(R.id.email);
        forpassword = findViewById(R.id.password);
        showpassword = findViewById(R.id.showpassword);
        showpassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    forpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    forpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
    private void startTosignup() {
        foremail = findViewById(R.id.email);
        forpassword = findViewById(R.id.password);
        showpassword = findViewById(R.id.showpassword);
        mAuth.createUserWithEmailAndPassword(foremail.getText().toString(),
                forpassword.getText().toString()).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && foremail.getText().toString().contains("illinois.edu")) {
                    mAuth.getCurrentUser().sendEmailVerification().
                            addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                if(mAuth.getCurrentUser().isEmailVerified()) {
                                    startActivity(intent);
                                }
                                Toast.makeText(MainActivity.this,
                                        "The link has been sent to your email!",
                                        Toast.LENGTH_LONG).show();
                                foremail.setText("");
                                forpassword.setText("");
                            } else {
                                Toast.makeText(MainActivity.this,
                                        task.getException().getMessage(),
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this,
                            "AAA sorry!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}



