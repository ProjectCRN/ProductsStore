package com.netcracker.crm.entity.controllerEntity.controllerService;

import com.netcracker.crm.entity.controllerEntity.Product;
import com.netcracker.crm.entity.controllerEntity.ProductList;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Ксения on 22.11.2016.
 */
@Component
public class ProductService {

    private static ProductList product;

    public ProductService() {
        if(product == null)
            product = new ProductList();
    }

    public static ProductList getProduct() {
        return product;
    }

    public static void setProduct(ProductList product) {
        ProductService.product = product;
    }

    public List<Product> getListProduct(){
        return product.getListProduct();
    }

    public Product find(int id){ return product.find(id);}
}
