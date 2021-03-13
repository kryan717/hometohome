package com.example.home_to_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        final Button button = (Button)findViewById(R.id.create_btn);
        final CheckBox checkBox = (CheckBox)findViewById(R.id.t_c_checkBox);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()) {
                    Intent intent = new Intent(CreateAccount.this, SetLocation.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(CreateAccount.this, "Please Accept the Terms and Conditions", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}