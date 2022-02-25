package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class myadapter2 extends ArrayAdapter {

    private Activity mContext3;

    List<contactd> contactdList;
    private static final int REQUEST_CALL = 1;

    public myadapter2(Activity mContext3,List<contactd> contactdList)
    {
        super(mContext3,R.layout.singlerow2,contactdList);
        //super(mContext,R.layout.customer_details,custList);
        this.mContext3 = mContext3;
        this.contactdList = contactdList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =mContext3.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.singlerow2,null,true);
        TextView tvname1 = listItemView.findViewById(R.id.nametext12);
        TextView tvcon = listItemView.findViewById(R.id.contactnotxt1);
        ImageView del = listItemView.findViewById(R.id.icondel);

        ImageView call = listItemView.findViewById(R.id.callicon);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String number = tvcon.getText().toString();
                makePhoneCall(number);

            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(del.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Delete...?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                        Query dQuery = ref.child("contacts").orderByChild("name2").equalTo(tvname1.getText().toString());

                        dQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                                    appleSnapshot.getRef().removeValue();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();

            }
        });





        contactd contactd1 = contactdList.get(position);
        tvname1.setText(contactd1.getName2());
        tvcon.setText((contactd1.getContactno()));
        return  listItemView;



    }




    private void makePhoneCall( String number) {
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(mContext3.getApplicationContext(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions( mContext3,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                mContext3.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(mContext3, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }

    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall("3");
            } else {
                Toast.makeText(mContext3, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }



}

