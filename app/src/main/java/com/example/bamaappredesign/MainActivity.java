package com.example.bamaappredesign;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    EditText e1, e2;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add Bama logo on Action Bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        e1 = findViewById(R.id.email);
        e2 = findViewById(R.id.password);

        auth = FirebaseAuth.getInstance();
        mPasswordView = findViewById(R.id.password);

        Button visitorButton = findViewById(R.id.visitor);
        visitorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visitorLogin();
            }
        });
    }

    //Visitor login button pressed
    private void visitorLogin(){
        Intent i = new Intent(getApplicationContext(), HomeVisitorActivity.class);
        startActivity(i);
    }

    public void loginUser(View v) {
        //If fields are empty, throw error
        if (e1.getText().toString().equals("") && e2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Must enter in Crimson email and password.", Toast.LENGTH_SHORT).show();
        } else {
            auth.signInWithEmailAndPassword(e1.getText().toString(), e2.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent i = new Intent(getApplicationContext(), HomeStudentActivity.class);
                                startActivity(i);
                            } else {
                                mPasswordView.setError("Password incorrect!");
                                mPasswordView.requestFocus();
                                Toast.makeText(getApplicationContext(), "Login unsuccessful...", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}