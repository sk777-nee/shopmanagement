package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class View_CustG_Activity extends AppCompatActivity {

    DatabaseReference reff;
    ListView listView;
    List<Customer>customer2s ;
    List<Customer2>customerList;
    DatabaseReference custreff,custreff2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__cust_g_);

        listView = findViewById(R.id.listView2);

        customerList = new ArrayList<>();
        customer2s = new ArrayList<>();
        custreff2 = FirebaseDatabase.getInstance().getReference("Customer");
        custreff=FirebaseDatabase.getInstance().getReference("Customer2");
        custreff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                customerList.clear();
                customer2s.clear();
                for(DataSnapshot memberDatsnap : snapshot.getChildren()){
                    Customer2 customer2= memberDatsnap.getValue(Customer2.class);
                    customerList.add(customer2);
                }
                ListAdapter2 adapter =new ListAdapter2(View_CustG_Activity.this,customerList);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






    }
}