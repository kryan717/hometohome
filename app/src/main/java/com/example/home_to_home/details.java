package com.example.home_to_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.home_to_home.R;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView name = (TextView)findViewById(R.id.itemName);
        TextView location = (TextView)findViewById(R.id.itemLocation);
        TextView desc = (TextView)findViewById(R.id.itemVendor);


        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("name");
            name.setText(j);

            String p =(String) b.get("address");
            location.setText(p);

            String k =(String) b.get("desc");
            desc.setText(k);
        }



    }
}