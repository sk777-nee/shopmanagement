package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Important_Contacts extends AppCompatActivity {



    DatabaseReference reff;
    ListView listView3;
  FloatingActionButton fba;
    List<contactd> contactdList;

    DatabaseReference contactreff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important__contacts);
        // Intent intent = getIntent();
        //String selectedItem = intent.getStringExtra("selectedItem");

        // Toolbar toolbar = findViewById(R.id.toolbar4);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("Customer Details");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView3 = findViewById(R.id.listView4);
        fba=(FloatingActionButton)findViewById(R.id.fadd1);
        fba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),addcontact.class));
            }
        });

        contactdList = new ArrayList<>();

        contactreff = FirebaseDatabase.getInstance().getReference("contacts");



        contactreff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                contactdList.clear();
                for(DataSnapshot memberDatsnap : snapshot.getChildren()){
                   contactd contactd1= memberDatsnap.getValue(contactd.class);
                   contactdList.add(contactd1);
                }
              myadapter2 adapter3 =new myadapter2(Important_Contacts.this,contactdList);
                listView3.setAdapter(adapter3);

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