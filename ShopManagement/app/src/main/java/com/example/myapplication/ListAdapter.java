package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter extends ArrayAdapter {

    private Activity mContext;

    List<Customer> custList;

    public ListAdapter(Activity mContext, List<Customer> custList)
    {
        super(mContext,R.layout.customer_details,custList);
        //super(mContext,R.layout.customer_details,custList);
        this.mContext = mContext;
        this.custList = custList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.customer_details,null,true);
        TextView tvname = listItemView.findViewById(R.id.tv_cust_name);
        TextView tvproduct = listItemView.findViewById(R.id.tv_product_name);
        TextView tvprice = listItemView.findViewById(R.id.tv_price);
        TextView tvmobile = listItemView.findViewById(R.id.tv_mobile);

       Customer customer = custList.get(position);
        tvname.setText(customer.getName());
        //tvid.setText(member.getId());
        tvproduct.setText(customer.getProduct());
        tvprice.setText(customer.getPrice());
        tvmobile.setText(customer.getMobile());
        return  listItemView;

    }


}
