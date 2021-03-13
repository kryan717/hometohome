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

public class LoginAccount extends AppCompatActivity {

    private EditText userEmail, userPassword;

    private String userID;
    private String email;


    private FirebaseAuth mAuth;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_account);

        userEmail = (EditText) findViewById(R.id.email);
        userPassword = (EditText) findViewById(R.id.password);


        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onStart() {

        super.onStart();
        if (mAuth.getCurrentUser() != null) {
            Intent nextActivity = new Intent(LoginAccount.this, MainActivity.class);
            startActivity(nextActivity);
        }
    }

    public void onClickLogin(View view) {
        email = userEmail.getText().toString().trim();
        final String password = userPassword.getText().toString().trim();

        // todo: add data validation

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginAccount.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginAccount.this, "auth failed, create new account!" + task.getException(), Toast.LENGTH_LONG).show();
                            Log.e("My Tag", task.getException().toString());
                        } else {
                            Intent intent = new Intent(LoginAccount.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });

    }

    public void onClickCreateAccount(View view) {
        Intent intent = new Intent(LoginAccount.this, CreateAccount.class);
        startActivity(intent);
        finish();
    }


}
