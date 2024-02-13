package com.vedruna.proyectomutimedia.dto;
/**
 * Clase que representa un producto en formato de Data Transfer Object (DTO).
 */
public class ProductDTO {
    private String name;
    private float price;
    private String imageUrl;

    /**
     * Constructor por defecto de ProductDTO.
     */
    public ProductDTO() {

    }
    /**
     * Constructor de ProductDTO con parámetros.
     *
     * @param name     Nombre del producto.
     * @param price    Precio del producto.
     * @param imageUrl URL de la imagen del producto.
     */
    public ProductDTO(String name, float price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
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
     * @param name El nombre del producto a establecer.
     */
    public void setName(String name) {
        this.name = name;
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
     * @param price El precio del producto a establecer.
     */
    public void setPrice(float price) {
        this.price = price;
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
     * @param imageUrl La URL de la imagen del producto a establecer.
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
