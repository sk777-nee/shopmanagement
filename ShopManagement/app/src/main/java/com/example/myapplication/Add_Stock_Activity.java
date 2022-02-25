package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Stock_Activity extends AppCompatActivity {
    EditText et1,et2,et3;
    Button btn;
    DatabaseReference reff;
    AddStock addStock1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__stock_);
        et1 =findViewById(R.id.et_iname1);
        et2 =findViewById(R.id.et_q);
        et3 = findViewById(R.id.etSpecifiaction);
        btn = findViewById(R.id.btna);
        addStock1=new AddStock();

        reff= FirebaseDatabase.getInstance().getReference().child("StockItem");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et1.getText().toString();
                String quantity = et2.getText().toString();
                String specification = et3.getText().toString();
                addStock1.setName(name);
                addStock1.setQuantity(quantity);
                addStock1.setSpecification(specification);
                reff.push().setValue(addStock1);
                Toast.makeText(Add_Stock_Activity.this, "data inserted", Toast.LENGTH_SHORT).show();

            }
        });




    }
}