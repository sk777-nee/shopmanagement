package com.example.myapplication;

import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class addcontact extends AppCompatActivity {

    EditText name1,contactno;
    Button submit1;
    DatabaseReference reff5;
    contactd contactd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);

        name1=findViewById(R.id.add_name1);
        contactno=findViewById(R.id.add_contactno);
        reff5=FirebaseDatabase.getInstance().getReference("contacts");



        submit1=(Button)findViewById(R.id.add_submit3);
        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,Object> map1=new HashMap<>();
                map1.put("name2",name1.getText().toString());
                map1.put("contactno",contactno.getText().toString());

                FirebaseDatabase.getInstance().getReference().child("contacts").push()
                        .setValue(map1)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                name1.setText("");
                                contactno.setText("");

                                Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e)
                            {
                                Toast.makeText(getApplicationContext(),"Could not insert",Toast.LENGTH_LONG).show();
                            }
                        });

            }

        });


    }


}