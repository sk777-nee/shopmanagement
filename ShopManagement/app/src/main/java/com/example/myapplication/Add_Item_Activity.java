package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Add_Item_Activity extends AppCompatActivity {

    Button _btnInsert;
    EditText _txt_IName , _txt_IQ , _txt_IP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__item_);


        Intent intent = getIntent();
        String l_name = intent.getStringExtra("l_name");

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Adding Items");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        _btnInsert = findViewById(R.id.btn_saveitem);
        _txt_IName = findViewById(R.id.et_item_name);
        _txt_IQ = findViewById(R.id.et_quantity);
        _txt_IP = findViewById(R.id.et_Iprice);

        _btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = _txt_IName.getText().toString();
                String quantity = _txt_IQ.getText().toString();
                String price = _txt_IP.getText().toString();
                String LN = l_name;




            }
        });




    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            com.example.myapplication.Add_Item_Activity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}