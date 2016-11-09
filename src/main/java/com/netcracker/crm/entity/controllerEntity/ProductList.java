package com.netcracker.crm.entity.controllerEntity;

import java.util.ArrayList;
import java.util.List;


public class ProductList {
    private List<Product> listProduct;

    public ProductList() {
        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "samsung", 100));
        listProduct.add(new Product(2, "apple", 101));
        listProduct.add(new Product(3, "nokia", 205));
    }

    public Product find(int id) {
        for (int i = 0; i < listProduct.size(); ++i)
            if (listProduct.get(i).getId() == id)
                return listProduct.get(i);
        return listProduct.get(0);
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }
}
