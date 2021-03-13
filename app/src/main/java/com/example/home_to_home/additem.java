package com.example.home_to_home;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class additem extends AppCompatActivity {

    EditText editItemName, editDescription;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        editItemName = (EditText)findViewById(R.id.setItem);
        editDescription = (EditText)findViewById(R.id.setDesc);

        add = (Button)findViewById(R.id.addItem);

    }
}