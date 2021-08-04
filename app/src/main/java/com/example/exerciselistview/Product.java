package com.example.exerciselistview;

public class Product {
    private String productName;
    private String productPrice;
    private int productImg;

    public Product(String productName, String productPrice, int productImg) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImg = productImg;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductImg() {
        return productImg;
    }

    public void setProductImg(int productImg) {
        this.productImg = productImg;
    }
}
