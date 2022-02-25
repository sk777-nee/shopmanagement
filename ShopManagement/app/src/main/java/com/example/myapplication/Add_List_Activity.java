package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Add_List_Activity extends AppCompatActivity {

Button _btnInsert;
EditText _txt_LName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__list_);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("List Name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        _btnInsert = findViewById(R.id.Btn_add_item1);
        _txt_LName = findViewById(R.id.et_list_name);




        _btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String l_name = _txt_LName.getText().toString();



                    Intent intent = new Intent(Add_List_Activity.this, Add_Item_Activity.class);
                    intent.putExtra("l_name",l_name);
                    startActivity(intent);
                }



        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            com.example.myapplication.Add_List_Activity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}