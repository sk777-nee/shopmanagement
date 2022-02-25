package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter4 extends RecyclerView.Adapter<MyAdapter4.MyViewHolder> {
    private static final int REQUEST_CALL = 1;

    private ArrayList<Model2> mList;
    private Activity context;


    public MyAdapter4(Activity context , ArrayList<Model2> mList){


        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item , parent ,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model2 model = mList.get(position);
        holder.wname.setText("Name: "+model.getWname());
        holder.waddress.setText("Address: "+model.getAddress());
        holder.wage.setText("Age: "+model.getAge());
        holder.wno.setText(model.getMobile());
        String upi=model.getUpi();
        String name = model.getWname();
        int sal = model.getSal();


        // holder.wsal.setText(String.valueOf(model.getSal()));
        Glide.with(context).load(mList.get(position).getImageUrl()).into(holder.imageView);
        holder.callicon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = holder.wno.getText().toString();
                makePhoneCall(number);

            }
        });
        holder.pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cound =holder.dayc.getText().toString();

                Intent intent = new Intent(context.getApplication(),Pay_Activity.class);
                intent.putExtra("cound",cound);
                intent.putExtra("upi",upi);
                intent.putExtra("name",name);
                intent.putExtra("sal",sal);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }





    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView , callicon2 ,pay;
        TextView wname,waddress,wno,wage,wsal;
        EditText dayc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.m_image);
            wname = itemView.findViewById(R.id.txtwname);
            waddress = itemView.findViewById(R.id.txtwaddress);
            wage = itemView.findViewById(R.id.txtwage);
            wno = itemView.findViewById(R.id.txtwmobile);
            //wsal = itemView.findViewById(R.id.txtsal);
            callicon2 = itemView.findViewById(R.id.callicon2);
            pay = itemView.findViewById(R.id.payicon);
            dayc = itemView.findViewById(R.id.dayc);

        }
    }

    private void makePhoneCall( String number) {
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(context,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions( context ,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(context, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }

    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall("3");
            } else {
                Toast.makeText(context, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

}


