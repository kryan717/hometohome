package com.example.home_to_home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class listings extends AppCompatActivity  {

    //private FirebaseAuth data1;
    //private FirebaseFirestore data;
    ListView listView;
    //private List<String> items = new ArrayList<String>();
    //private List<String> label = new ArrayList<String>();
    //Query query;
    ArrayAdapter adapter;
    private Button button;
    EditText name;
    String address;
    private String product;
    //User A;
    //String UserID;
    //private String user;
    String test_list2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listings);

        button = (Button)findViewById(R.id.searchButton);

        name = (EditText)findViewById(R.id.searchName);

        address = name.getText().toString();


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
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
               test_list2 = new String[test_list.size()];
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
                listView = (ListView)findViewById(R.id.tradeListView);
                adapter = new ArrayAdapter(listings.this, android.R.layout.simple_list_item_1, test_list2);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> adapter, View v, int position,
                                            long arg3)
                    {
                        product=test_list2[position];
                        Intent intent = new Intent(listings.this,details.class);
                        /*intent.putExtra("Item",label.get(position));
                        intent.putExtra("owner",A.getName());
                        intent.putExtra("email",A.getUsername());
                        intent.putExtra("Zipcode",address);*/
                    }
                });
            }
        });
                //Query query = data.collection("words").whereEqualTo("zipcode",address);
                //data1 = FirebaseAuth.getInstance();
                /*String UserID = data1.getCurrentUser().getUid();
                user = data.collection("name").document(UserID).toString();*/
                /*data = FirebaseFirestore.getInstance();
                CollectionReference applicationsRef = data.collection("items");
                DocumentReference applicationidRef = applicationsRef.*/

                /*CollectionReference reference= data.collection("user");
                Query query1 = reference.whereEqualTo("zipcode",address);
                Task<DocumentSnapshot> picture = (Task<DocumentSnapshot>)query1.get(String, "items");
                items = picture.get

                Query query2 = query1.whereEqualTo()
                FirebaseFirestore.getInstance().collection("user").whereEqualTo("zipcode",address)
                        .get()
                        .addOnCompleteListener(new
                                                       OnCompleteListener<DocumentSnapshot>() {
                                                           @Override
                                                           public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                               DocumentSnapshot document = task.getResult();
                                                               query.whereGreaterThan("name",0);

                                                               String group_string= document.getData().toString();
                                                               String[] group_array = ????
                                                               Log.d("myTag", group_string);
                                                           }
                                                       });
                        /*.get()
                        .addOnCompleteListener(new  OnCompleteListener<DocumentSnapshot>() {
                                                           @Override
                                                           public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                               DocumentSnapshot document = task.getResult();
                                                               items.add(document.get("name").toString());
                                                           }
                                                       };*/
              /*  data.collection("users")
                        .whereEqualTo("zipcode",address)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>(){
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task){
                                if(task.isSuccessful()) {
                                    for(QueryDocumentSnapshot document: task.getResult()){
                                        product = document.getString("items");
                                        product = product.substring("")
                                    } */
                                        /*A = new User(document.get("email").toString(),
                                                document.get("name").toString(), document.get("phoneNumber").toString());*/
                                        //items.add(document.get("items").toString());
                                      /* A = document.toObject(User.class);
                                         items.addAll(A.getItems("owned"));
                                         for(Item item:items){
                                             label.add(item.getName());
                                         }*/                                          /*A = new User(document.get("email").toString(),
                                                document.get("name").toString(), document.get("phoneNumber").toString());
                                        items.add(document.get("items").toString());*/
                                    //}
                                //});

                            //}
                        //});




    }

}