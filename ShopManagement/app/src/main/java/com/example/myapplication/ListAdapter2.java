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

public class ListAdapter2 extends ArrayAdapter {

    private Activity mContext2;

    List<Customer2> custList2;

    public ListAdapter2(Activity mContext2,List<Customer2> custList2)
    {
        super(mContext2,R.layout.customer_details,custList2);
        //super(mContext,R.layout.customer_details,custList);
        this.mContext2 = mContext2;
        this.custList2 = custList2;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =mContext2.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.customer_details,null,true);
        TextView tvname = listItemView.findViewById(R.id.tv_cust_name);
        TextView tvproduct = listItemView.findViewById(R.id.tv_product_name);
        TextView tvprice = listItemView.findViewById(R.id.tv_price);
        TextView tvmob = listItemView.findViewById(R.id.tv_mobile);

        Customer2 customer2 = custList2.get(position);
        tvname.setText(customer2.getName1());
        //tvid.setText(member.getId());
        tvproduct.setText(customer2.getProduct1());
        tvprice.setText(customer2.getPrice1());
        tvmob.setText(customer2.getMobile1());
        return  listItemView;

    }


}
