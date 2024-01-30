package com.vedruna.proyectomutimedia.model;

import java.io.Serializable;

public class Product implements Serializable {

    private int productID;


    private String name;


    private float price;

    private String imageUrl;

    public Product() {
    }

    public Product(int productID, String name, float price, String imageUrl) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float precio) {
        this.price = precio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Id: "+getProductID()+"Name: "+ getName()+"Price: "+getPrice()+ "URL: "+getImageUrl();
    }
}
