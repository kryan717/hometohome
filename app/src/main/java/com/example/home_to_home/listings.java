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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class listings extends AppCompatActivity  {

    private FirebaseAuth data1;
    private FirebaseFirestore data;
    ListView listView;
    private List<String> items = new ArrayList<String>();
    ArrayAdapter adapter;
    private Button button;
    EditText name;
    String address;
    private String product;
    User A;
    String UserID;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listings);

        button = (Button)findViewById(R.id.searchButton);

        name = (EditText)findViewById(R.id.searchName);



        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                address = name.getText().toString();
                data = FirebaseFirestore.getInstance();
                data1 = FirebaseAuth.getInstance();

                String UserID = data1.getCurrentUser().getUid();
                user = data.collection("name").document(UserID).toString();

                data.collection("users")
                        .whereEqualTo("zipcode",address)
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
                listView = (ListView)findViewById(R.id.tradeListView);
                adapter = new ArrayAdapter(listings.this, android.R.layout.simple_list_item_1, items);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> adapter, View v, int position,
                                            long arg3)
                    {
                        product=items.get(position);
                        Intent intent = new Intent(listings.this,details.class);
                        intent.putExtra("Item",items.get(position));
                        intent.putExtra("owner",A.getName());
                        intent.putExtra("email",A.getUsername());
                        intent.putExtra("Zipcode",address);
                    }
                });
            }
        });
    }
}