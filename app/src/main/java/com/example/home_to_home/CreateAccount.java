package com.example.home_to_home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreateAccount extends AppCompatActivity {

    private EditText newUserEmail, newUserPassword, userName, userPhone;

    private String userID;
    private String email;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        newUserEmail = (EditText) findViewById(R.id.input_email);
        newUserPassword = (EditText) findViewById(R.id.input_password);
        userName = (EditText) findViewById(R.id.input_name);
        userPhone = (EditText) findViewById(R.id.input_contact_number);

        mAuth = FirebaseAuth.getInstance();

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(checkBox.isChecked()) {
//                    Intent intent = new Intent(com.example.home_to_home.CreateAccount.this, SetLocation.class);
//                    startActivity(intent);
//                }
//                else {
//                    Toast.makeText(com.example.home_to_home.CreateAccount.this, "Please Accept the Terms and Conditions", Toast.LENGTH_SHORT);
//                }
//            }
//        });
    }

    @Override
    public void onStart() {

        super.onStart();
        if (mAuth.getCurrentUser() != null) {
            Intent nextActivity = new Intent(CreateAccount.this, SetLocation.class);
            startActivity(nextActivity);        }
    }

    public void createAccount(View view) {
        String email = newUserEmail.getText().toString().trim();
        String password = newUserPassword.getText().toString().trim();
        String name = userName.getText().toString().trim();
        String phone = userPhone.getText().toString().trim();

        //TODO: add data validation

        Task<AuthResult> myTag = mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(CreateAccount.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(CreateAccount.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_LONG).show();
                            Log.e("MyTag", task.getException().toString());
                        } else {
                            addFireBaseUser(email, name, phone);
                            Intent nextActivity = new Intent(CreateAccount.this, SetLocation.class);
                            startActivity(nextActivity);
                        }
                    }
                });
    }

    public void addFireBaseUser(String email, String name, String phone){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        userID = user.getUid();
        User user_db = new User(email, name, phone);
        db.collection("users").document(this.userID).set(user_db);


    }

}