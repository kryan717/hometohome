package com.example.home_to_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.listingsTest);
        b2 = (Button) findViewById(R.id.detailsTest);
        b3 = (Button) findViewById(R.id.queueTest);
        b4 = (Button) findViewById(R.id.addItem);
        b5 = (Button) findViewById(R.id.tradeTest);
        b6 = (Button) findViewById(R.id.tradeConfirm);

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

        b5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { openTrade(); }
        });

        b6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { openTradeConfirm(); }
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
    public void openTrade(){
        Intent i1 = new Intent(this, tradeInterface.class);
        startActivity(i1);
    }
    public void openTradeConfirm(){
        Intent i1 = new Intent(this, trade_confirmation.class);
        startActivity(i1);
    }
}