package com.vedruna.proyectomutimedia.model;

import java.io.Serializable;

/**
 * Clase que representa un producto.
 */
public class Product implements Serializable {

    private int productID;


    private String name;


    private float price;

    private String imageUrl;
    /**
     * Constructor por defecto de la clase Product.
     */
    public Product() {
    }
    /**
     * Constructor de la clase Product.
     *
     * @param productID El ID del producto.
     * @param name      El nombre del producto.
     * @param price     El precio del producto.
     * @param imageUrl  La URL de la imagen del producto.
     */
    public Product(int productID, String name, float price, String imageUrl) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
    /**
     * Método getter para obtener el ID del producto.
     *
     * @return El ID del producto.
     */
    public int getProductID() {
        return productID;
    }
    /**
     * Método setter para establecer el ID del producto.
     *
     * @param productID El ID del producto.
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }
    /**
     * Método getter para obtener el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getName() {
        return name;
    }
    /**
     * Método setter para establecer el nombre del producto.
     *
     * @param nombre El nombre del producto.
     */
    public void setName(String nombre) {
        this.name = nombre;
    }
    /**
     * Método getter para obtener el precio del producto.
     *
     * @return El precio del producto.
     */
    public float getPrice() {
        return price;
    }
    /**
     * Método setter para establecer el precio del producto.
     *
     * @param precio El precio del producto.
     */
    public void setPrice(float precio) {
        this.price = precio;
    }
    /**
     * Método getter para obtener la URL de la imagen del producto.
     *
     * @return La URL de la imagen del producto.
     */
    public String getImageUrl() {
        return imageUrl;
    }
    /**
     * Método setter para establecer la URL de la imagen del producto.
     *
     * @param imageUrl La URL de la imagen del producto.
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    /**
     * Método toString para representar el producto como una cadena de texto.
     *
     * @return Una cadena de texto que representa el producto.
     */
    @Override
    public String toString() {
        return "Id: "+getProductID()+"Name: "+ getName()+"Price: "+getPrice()+ "URL: "+getImageUrl();
    }
}
