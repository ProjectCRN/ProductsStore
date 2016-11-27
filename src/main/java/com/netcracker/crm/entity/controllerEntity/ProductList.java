package com.netcracker.crm.entity.controllerEntity;

import java.util.ArrayList;
import java.util.List;


public class ProductList {
    private List<Product> listProduct;

    public ProductList() {
        listProduct = new ArrayList<>();
        String urlImg = "/resources/img/img_phone.jpg";
        listProduct.add(new Product(1, "samsung", 100, urlImg ));
        listProduct.add(new Product(2, "apple", 101, urlImg));
        listProduct.add(new Product(3, "nokia", 205, urlImg));
        listProduct.add(new Product(4, "nokia 4", 205, urlImg));
        listProduct.add(new Product(5, "nokia 5", 205, urlImg));
        listProduct.add(new Product(6, "nokia 6", 205, urlImg));
        listProduct.add(new Product(7, "nokia 7", 205, urlImg));
        listProduct.add(new Product(8, "nokia 8", 205, urlImg));
        listProduct.add(new Product(9, "nokia 9", 205, urlImg));
        listProduct.add(new Product(10, "nokia 10", 205, urlImg));
        listProduct.add(new Product(11, "nokia 11", 205, urlImg));
        listProduct.add(new Product(12, "nokia 12", 205, urlImg));
        listProduct.add(new Product(13, "nokia 13", 205, urlImg));
        listProduct.add(new Product(14, "nokia 14", 205, urlImg));
        listProduct.add(new Product(15, "nokia 15", 205, urlImg));
        listProduct.add(new Product(16, "nokia 16", 205, urlImg));
        listProduct.add(new Product(17, "nokia 17", 205, urlImg));
        listProduct.add(new Product(18, "nokia 18", 205, urlImg));
        listProduct.add(new Product(19, "nokia 19", 205, urlImg));
        listProduct.add(new Product(20, "nokia 20", 205, urlImg));
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
