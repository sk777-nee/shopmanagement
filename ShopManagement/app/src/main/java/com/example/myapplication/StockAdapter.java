package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StockAdapter extends ArrayAdapter {

    private Activity mContext3;

    List<AddStock> addStockList;

    public StockAdapter(Activity mContext3,List<AddStock> addStockList)
    {
        super(mContext3,R.layout.activity_check_stock2,addStockList);
        //super(mContext,R.layout.customer_details,custList);
        this.mContext3 = mContext3;
        this.addStockList = addStockList;




    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =mContext3.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.activity_check_stock2,null,true);
        EditText tvname = listItemView.findViewById(R.id.tv_SIN);
        EditText tvq = listItemView.findViewById(R.id.tv_SIQ);
        EditText tvs = listItemView.findViewById(R.id.tv_SIS);

      AddStock addStock = addStockList.get(position);
        tvname.setText(addStock.getName());
        //tvid.setText(member.getId());
        tvq.setText(addStock.getQuantity());
        tvs.setText(addStock.getSpecification());
        return  listItemView;

    }



}
