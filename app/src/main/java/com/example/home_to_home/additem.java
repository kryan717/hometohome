package com.example.home_to_home;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class additem extends AppCompatActivity {

    private EditText editItemName, editDescription;
    private FirebaseAuth mAuth;
    private String userID, itemName, itemDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        editItemName = (EditText)findViewById(R.id.setItem);
        editDescription = (EditText)findViewById(R.id.setDesc);

    }

    public void onAddItem(View view){
        itemName = editItemName.getText().toString().trim();
        itemDesc = editDescription.getText().toString().trim();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        userID = user.getUid();

        Map<String, Object> data = new HashMap<>();
        data.put("name", itemName);
        data.put("description", itemDesc);



        db.collection("users").document(this.userID).collection("items").add(data);

        finish();
        startActivity(getIntent());

    }
}