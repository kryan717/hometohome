
package com.example.home_to_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.home_to_home.R;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView name = (TextView)findViewById(R.id.itemName);
        TextView location = (TextView)findViewById(R.id.itemLocation);
        TextView desc = (TextView)findViewById(R.id.itemPrice);
        Button button = (Button)findViewById(R.id.listingsReturn);


        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j ="Item:" + (String) b.get("name") ;
            name.setText(j);

            String p ="Zipcode:" + (String) b.get("address");
            location.setText(p);

            String k ="$" + (String) b.get("desc");
            desc.setText(k);
        }
        button.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v) {
           Intent intent = new Intent(details.this,listings.class);
           startActivity(intent);

       }
  });
    }
}