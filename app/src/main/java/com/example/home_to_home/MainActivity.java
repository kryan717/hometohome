package com.example.home_to_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.listingsTest);
        b2 = (Button) findViewById(R.id.detailsTest);
        b3 = (Button) findViewById(R.id.queueTest);

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
}