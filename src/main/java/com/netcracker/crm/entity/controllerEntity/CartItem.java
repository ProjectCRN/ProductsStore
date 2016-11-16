package com.netcracker.crm.entity.controllerEntity;


public class CartItem {
    private Product product;
    private int number;

    public CartItem() {
        number = 0;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", number=" + number +
                '}';
    }
}