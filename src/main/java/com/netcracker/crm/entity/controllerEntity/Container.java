package com.netcracker.crm.entity.controllerEntity;


public class Container {
    private static Cart cart = new Cart();
    private static ProductList productList = new ProductList();

    public static ProductList getProductList() {
        return productList;
    }

    public static Cart getCart() {
        return cart;
    }
}
