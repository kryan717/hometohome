package com.example.home_to_home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView name = (TextView)findViewById(R.id.itemName);
        TextView location = (TextView)findViewById(R.id.itemLocation);
        TextView vendor = (TextView)findViewById(R.id.itemVendor);

        name.setText("Cheesecake");
        location.setText("Merced, CA");
        vendor.setText("John Doe");

    }
}