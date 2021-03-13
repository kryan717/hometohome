package com.example.home_to_home;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class listings extends AppCompatActivity {

    ListView listView;
    List list = new ArrayList();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings);

        listView = (ListView)findViewById(R.id.tradeListView);
        list.add("test");
        list.add("test");
        list.add("test");
        list.add("test");
        list.add("test");
        list.add("test");
        list.add("test");
        list.add("test");
        list.add("test");
        list.add("test");
        list.add("pizza");
        list.add("test");
        list.add("test");
        list.add("test");
        list.add("test");

        adapter = new ArrayAdapter(listings.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    public Query getListings(int zipcode){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference users = db.collection("users");
        Query usersInZip = users.whereEqualTo("zipcode", zipcode);
        return usersInZip;
    }
}