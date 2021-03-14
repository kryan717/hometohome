package com.example.home_to_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.home_to_home.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class listings_attempt extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private Task<QuerySnapshot> querySnapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings_attempt);

        Log.i("TESTDATA", "test");

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseFirestore db = FirebaseFirestore.getInstance();


        List<Map> test_list = new ArrayList<Map>();

        db.collectionGroup("items")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    private static final String TAG = "";

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                test_list.add(document.getData());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
        String[] test_list2 = new String[test_list.size()];
        int count = 0;
        for (Map<String, Object> map : test_list) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = (String) entry.getValue();
                test_list2[count] = key + value;
                Log.i("TESTDATA", test_list2[count]);
                count = count + 1;
            }
        }
//        CustomAdapter list_data = new CustomAdapter(test_list2);
    }

    }