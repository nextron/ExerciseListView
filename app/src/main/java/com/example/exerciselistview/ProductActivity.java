package com.example.exerciselistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    ListView lvProducts;
    TextView txvUserName;
    ArrayList<Product> productList = new ArrayList<>();

    public static Product productObj = new Product("","",0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        fillProducts();

        txvUserName = findViewById(R.id.txvUserName);
        lvProducts = findViewById(R.id.lvProducts);

        txvUserName.setText(MainActivity.loggedInClient.getName());
        lvProducts.setAdapter(new ProductAdaptor(this, productList));

        lvProducts.setOnItemClickListener((parent, view, position, id) -> {
            productObj = productList.get(position);
            Intent intent = new Intent(ProductActivity.this, ProductViewActivity.class);
            startActivity(intent);
        });
    }

    private void fillProducts(){
        productList.add(new Product("Capsicum","1.13 $",R.mipmap.capsicum));;
        productList.add(new Product("Tomato","1.50 $", R.mipmap.tomato));
        productList.add(new Product("Lettuce", "2.10 $", R.mipmap.lettuce));
    }
}