package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class View_Cust_Activity extends AppCompatActivity {

    //Button b1,b2;




    //ListView listView;
    DatabaseReference reff;
    ListView listView;
    List<Customer> customerList;
    List<Customer2>customer2s;
    DatabaseReference custreff,custreff2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__cust_);
       // Intent intent = getIntent();
        //String selectedItem = intent.getStringExtra("selectedItem");

       // Toolbar toolbar = findViewById(R.id.toolbar4);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("Customer Details");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = findViewById(R.id.listView1);
        customerList = new ArrayList<>();
        customer2s = new ArrayList<>();
        custreff = FirebaseDatabase.getInstance().getReference("Customer");
        custreff2=FirebaseDatabase.getInstance().getReference("Customer2");


        custreff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                customerList.clear();
                customer2s.clear();
                for(DataSnapshot memberDatsnap : snapshot.getChildren()){
                   Customer customer= memberDatsnap.getValue(Customer.class);
                    customerList.add(customer);
                }
                ListAdapter adapter =new ListAdapter(View_Cust_Activity.this,customerList);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });








    }

    //@Override
   // public boolean onOptionsItemSelected(MenuItem item) {
     //   if(item.getItemId()==android.R.id.home)
       // {
         //   com.example.myapplication.View_Cust_Activity.this.finish();
        //}
        //return super.onOptionsItemSelected(item);
    //}
}