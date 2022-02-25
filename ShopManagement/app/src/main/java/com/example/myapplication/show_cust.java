package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class show_cust extends AppCompatActivity {

    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cust);


        Toolbar toolbar = findViewById(R.id.toolbarsc);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("choose category");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        b1 = findViewById(R.id.bf);
        b2 = findViewById(R.id.bg);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItem = b1.getText().toString();
                Intent intent = new Intent(show_cust.this,View_Cust_Activity.class);
               // intent.putExtra("selectedItem",selectedItem);
                startActivity(intent);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItem = b2.getText().toString();
                Intent intent = new Intent(show_cust.this,View_CustG_Activity.class);
                //intent.putExtra("selectedItem",selectedItem);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            com.example.myapplication.show_cust.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}