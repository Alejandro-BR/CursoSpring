package com.alejandro.curso.springboot.di.factura.springboot_difactura.models;

public class Item {

    private Product product;
    
    private Integer quiantity;

    public Item(Product product, Integer quiantity) {
        this.product = product;
        this.quiantity = quiantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuiantity() {
        return quiantity;
    }

    public void setQuiantity(Integer quiantity) {
        this.quiantity = quiantity;
    }

    public int getImporte() {
        return quiantity * product.getPrice();
    }

}
