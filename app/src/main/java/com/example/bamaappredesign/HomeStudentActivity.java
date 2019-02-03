package com.example.bamaappredesign;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class HomeStudentActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    TextView profileTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_student);

        // Add Bama logo on Action Bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        auth = FirebaseAuth.getInstance();
        profileTxt = (TextView)findViewById(R.id.welcomeText);
        user = auth.getCurrentUser();

        //Display user's email
        profileTxt.setText("Welcome, " + user.getEmail() + "!");
    }

    public void signOut(android.view.View view) {
        auth.signOut();
        finish();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}