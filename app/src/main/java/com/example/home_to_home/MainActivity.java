package com.example.home_to_home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.listingsTest);
        b2 = (Button) findViewById(R.id.detailsTest);
        b3 = (Button) findViewById(R.id.queueTest);
        b4 = (Button) findViewById(R.id.addItem);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openListings();
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openDetails();
            }
        });

        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openQueued();
            }
        });

        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAdd();
            }
        });

    }

    public void onLogout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, LoginAccount.class));
    }

    public void openListings(){
        Intent i1 = new Intent(this, listings.class);
        startActivity(i1);
    }
    public void openDetails(){
        Intent i1 = new Intent(this, details.class);
        startActivity(i1);
    }
    public void openQueued(){
        Intent i1 = new Intent(this, testqueued.class);
        startActivity(i1);
    }
    public void openAdd(){
        Intent i1 = new Intent(this, additem.class);
        startActivity(i1);
    }
}