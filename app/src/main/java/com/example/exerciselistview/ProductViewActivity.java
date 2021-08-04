package com.example.exerciselistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductViewActivity extends AppCompatActivity {

    TextView txvProductName, txvProductPrice, txvUser;
    ImageView imgProductImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

        txvProductName = findViewById(R.id.txvProductName);
        txvProductPrice = findViewById(R.id.txvProductPrice);
        imgProductImage = findViewById(R.id.imgProductImage);
        txvUser = findViewById(R.id.txvUser);

        txvUser.setText(MainActivity.loggedInClient.getName());
        txvProductName.setText(ProductActivity.productObj.getProductName());
        txvProductPrice.setText(ProductActivity.productObj.getProductPrice());
        imgProductImage.setImageResource(ProductActivity.productObj.getProductImg());
    }
}