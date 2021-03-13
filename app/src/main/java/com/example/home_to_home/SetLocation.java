package com.example.home_to_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class SetLocation extends AppCompatActivity {

    private EditText city, state, zipcode, country;

    private String userID;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_location);

        city = (EditText) findViewById(R.id.city);
        state = (EditText) findViewById(R.id.state);
        zipcode = (EditText) findViewById(R.id.zip);
        country = (EditText) findViewById(R.id.country);

        mAuth = FirebaseAuth.getInstance();

    }

    public void setLocationBtn(View view){
        String zipcode_db = zipcode.getText().toString().trim();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        userID = user.getUid();


        db.collection("users").document(this.userID).update("zipcode", zipcode_db);

        Intent nextActivity = new Intent(SetLocation.this, MainActivity.class);
        startActivity(nextActivity);

    }
}