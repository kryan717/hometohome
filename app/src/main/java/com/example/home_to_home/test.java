package com.example.home_to_home;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.firestore.FirebaseFirestore;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }

    public void sendMessage(View view){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();

        db.collection("strings").add(message);

    }
}