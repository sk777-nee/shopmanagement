package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;



import java.util.ArrayList;

public class Show_List_Activity extends AppCompatActivity {


    ListView listView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__list_);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        Toolbar toolbar = findViewById(R.id.set_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("List Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);







        listView = findViewById(R.id._lv);






    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            com.example.myapplication.Show_List_Activity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}