package com.example.home_to_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class listings extends AppCompatActivity  {

    private FirebaseFirestore data;
    ListView list;
    private List<String> items = new ArrayList<String>();
    private Button button;
    EditText name;
    String address;
    private String product;
    User A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listings);

        button = (Button) findViewById(R.id.searchButton);

        name = (EditText) findViewById(R.id.searchName);
    }


    public void onClickListings(View v){
        address = name.getText().toString();
        data = FirebaseFirestore.getInstance();
        data.collection("users")
                .whereEqualTo("zipcode", address)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>(){
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task){
                        if(task.isSuccessful()) {
                            for(QueryDocumentSnapshot document: task.getResult()){
                                A = new User(document.get("email").toString(),
                                        document.get("name").toString(), document.get("phoneNumber").toString());
                                items.add(document.get("items").toString());
                            }
                        }

                    }
                });
        list = (ListView) findViewById(R.id.tradeListView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?> adapter, View v, int position,
//                                    long arg3)
//            {
//                product=items.get(position);
//                Intent intent = new Intent(listings.this, details.class);
//                intent.putExtra("Item",items.get(position));
//                intent.putExtra("owner",A.getName());
//                intent.putExtra("email",A.getUsername());
//                intent.putExtra("Zipcode",address);
//            }
//        });
    }







}
