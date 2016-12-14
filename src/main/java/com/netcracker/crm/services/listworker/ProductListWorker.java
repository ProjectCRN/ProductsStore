package com.netcracker.crm.services.listworker;


import com.netcracker.crm.entity.serviceEntity.Product;

import java.util.List;


public class ProductListWorker {
    private ProductListWorker() {

    }

    public static boolean containsNameIgnoreCaseAndWhitespace(List<Product> productList, String name) {
        String s = name.replace(" ", "");
        for (Product product : productList) {
            if (product.getEntityName().replace(" ", "").equalsIgnoreCase(s))
                return true;
        }

        return false;
    }

}
