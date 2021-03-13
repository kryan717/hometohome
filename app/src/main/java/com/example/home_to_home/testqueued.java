package com.example.home_to_home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class testqueued extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testqueued);

        TextView number = (TextView)findViewById(R.id.queueNumber);
        TextView info = (TextView)findViewById(R.id.itemInfo);

        int num = 5;
        String item = "Cheesecake";
        String location = "Merced, CA";
        String vendor = "John Doe";

        number.setText(num + "th");
        info.setText(item + ", " + location + ", by " + vendor);
    }
}