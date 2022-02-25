package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;




import java.util.ArrayList;

public class View_List_Activity extends AppCompatActivity {

    ListView listView;


    Button btn;
    EditText et;
    Button btn1;
    String name1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__list_);

        listView = findViewById(R.id._dynamic);
        btn = findViewById(R.id.btnshow);
        et=findViewById(R.id.et_show);
        btn1= findViewById(R.id.btndel);
        Toolbar toolbar = findViewById(R.id.set_toolbarvl);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Customer Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String  name = et.getText().toString();

               Intent intent = new Intent(View_List_Activity.this, Show_List_Activity.class);
               intent.putExtra("name",name);
               startActivity(intent);


            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  name1 = et.getText().toString();


                Intent intent = new Intent(View_List_Activity.this, View_List_Activity.class);
                startActivity(intent);









            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            com.example.myapplication.View_List_Activity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}