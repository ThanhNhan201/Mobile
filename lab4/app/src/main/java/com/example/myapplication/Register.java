package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class Register extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText fullnameEditText;
    private EditText phoneEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button registerButton;
    ProgressBar processBar;
    private TextView loginRedirectText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();
        fullnameEditText = findViewById(R.id.fullname);
        phoneEditText = findViewById(R.id.phone);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        registerButton = findViewById(R.id.btn_register);
        loginRedirectText = findViewById(R.id.loginNow);
        processBar = findViewById(R.id.progressBar);

        registerButton.setOnClickListener(new View.OnClickListener() {
            private void saveUserDataToDatabase(String userId, String phone, String fullname) {
                DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();
                DatabaseReference usersRef = databaseRef.child("users");
                DatabaseReference currentUserRef = usersRef.child(userId);
                currentUserRef.child("phone").setValue(phone);
                currentUserRef.child("fullname").setValue(fullname);
            }

            @Override
            public void onClick(View view) {
                processBar.setVisibility(View.VISIBLE);
//                String email =  EmailUtils.generateRandomEmail();
                String fullname = fullnameEditText.getText().toString().trim();
                String phone = phoneEditText.getText().toString().trim();
                String username = usernameEditText.getText().toString().trim();
                String email = username + "@gmail.com";
                String password = passwordEditText.getText().toString().trim();


                if (fullname.isEmpty()) {
                    fullnameEditText.setError("Fullname cannot empty!");
                }

                if (phone.isEmpty()) {
                    phoneEditText.setError("Phone cannot empty!");
                }

                if (username.isEmpty()) {
                    usernameEditText.setError("Username cannot empty!");
                }

//                if (length(username) < 6)

                if (password.isEmpty()) {
                    passwordEditText.setError("Password cannot empty!");
                } else {
                    auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        String userId = task.getResult().getUser().getUid();

                                        // Save additional user data (phone) to Realtime Database
                                        saveUserDataToDatabase(userId, phone, fullname);

                                        Toast.makeText(Register.this, "Sign up successful", Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(Register.this, Login.class));
                                    } else {
                                        Toast.makeText(Register.this, "Sign up failed" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });


        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
    }
}