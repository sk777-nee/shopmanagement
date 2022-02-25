package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Check_Stock_Activity extends AppCompatActivity {

    DatabaseReference reff;
    ListView listView;
    List<AddStock> addStockList;
    Button btnu;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check__stock_);



        listView = findViewById(R.id.listView3);
        btnu = findViewById(R.id.btnUpdate4);
        addStockList = new ArrayList<>();

        reff = FirebaseDatabase.getInstance().getReference("StockItem");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               addStockList.clear();

                for(DataSnapshot memberDatsnap : snapshot.getChildren()){
                  AddStock addStock = memberDatsnap.getValue(AddStock.class);
                    addStockList.add(addStock);
                }
                StockAdapter adapter =new StockAdapter(Check_Stock_Activity.this,addStockList);
                listView.setAdapter(adapter);

            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });











    }


}