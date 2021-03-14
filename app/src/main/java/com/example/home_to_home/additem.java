package com.example.home_to_home;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class additem extends AppCompatActivity {

    EditText editItemName;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        editItemName = (EditText)findViewById(R.id.setItem);

        add = (Button)findViewById(R.id.addItem);

    }
}