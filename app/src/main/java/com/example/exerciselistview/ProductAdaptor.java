package com.example.exerciselistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdaptor extends BaseAdapter {

    private ArrayList<Product> products;
    private LayoutInflater inflater;

    public ProductAdaptor(Context context, ArrayList<Product> products) {
        this.products = products;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.product_row, null);
            holder = new ViewHolder();
            holder.productName = convertView.findViewById(R.id.txvName);
            holder.productPrice = convertView.findViewById(R.id.txvPrice);
            holder.productImage = convertView.findViewById(R.id.imgProduct);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.productName.setText(products.get(position).getProductName());
        holder.productPrice.setText(products.get(position).getProductPrice());
        holder.productImage.setImageResource(products.get(position).getProductImg());
        return convertView;
    }

    static class ViewHolder{
        private TextView productName, productPrice;
        private ImageView productImage;
    }
}
