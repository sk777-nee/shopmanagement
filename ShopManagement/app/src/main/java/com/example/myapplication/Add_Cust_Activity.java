package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Cust_Activity extends AppCompatActivity {
    Button _btnInert;
    EditText _txtName,_txtProduct,_txtPrice,_txtCat,_txtmobile;
    DatabaseReference reff , reff2;
    Customer customer;
    Customer2 customer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__cust_);


        Toolbar toolbar = findViewById(R.id.set_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Customer Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        _btnInert = findViewById(R.id.Btn_Add_cust);
        _txtName = findViewById(R.id.et_cust_name);
        _txtProduct = findViewById(R.id.et_product_name);
        _txtPrice = findViewById(R.id.et_price);
        _txtCat = findViewById(R.id.et_catno);
        _txtmobile=findViewById(R.id.et_mob);

        customer=new Customer();
        customer2=new Customer2();
        reff= FirebaseDatabase.getInstance().getReference().child("Customer");
        reff2= FirebaseDatabase.getInstance().getReference().child("Customer2");


        _btnInert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = _txtCat.getText().toString();


                //String category2 = _txtCat.getText().toString();
                if((category.equals("G")) || (category.equals("g")))
                {
                    String name1 = _txtName.getText().toString();
                    String product1 = _txtProduct.getText().toString();
                    String price1 = _txtPrice.getText().toString();
                    String mobile1 = _txtmobile.getText().toString();

                    customer2.setName1(name1);
                    customer2.setProduct1(product1);
                    //customer.setCategory(category);
                    customer2.setPrice1(price1);
                    customer2.setMobile1(mobile1);

                    reff2.push().setValue(customer2);
                    Toast.makeText(Add_Cust_Activity.this, "data inserted", Toast.LENGTH_SHORT).show();

                }
                if((category.equals("F")) || (category.equals("f"))) {


                    String name = _txtName.getText().toString();
                    String product = _txtProduct.getText().toString();
                    String price = _txtPrice.getText().toString();
                    String mobile = _txtmobile.getText().toString();
                    customer.setName(name);
                    customer.setProduct(product);
                    //customer.setCategory(category);
                    customer.setPrice(price);
                    customer.setMobile(mobile);
                    reff.push().setValue(customer);
                    Toast.makeText(Add_Cust_Activity.this, "data inserted", Toast.LENGTH_SHORT).show();
                }




                /*Toast.makeText(getApplicationContext(),"Inserted successfully",Toast.LENGTH_LONG).show();
                _txtName.setText("");
                _txtCat.setText("");
                _txtPrice.setText("");
                _txtProduct.setText("");*/


            }
        });




    }



    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            com.example.myapplication.Add_Cust_Activity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
