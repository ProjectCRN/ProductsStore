package com.netcracker.crm.services.listworker;

import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.serviceEntity.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by egor on 27.11.2016.
 */
public class ProductListWorker {
    private ProductListWorker(){

    }
    public static boolean containsNameIgnoreCaseAndWhitespace(List<Product> productList, String name){
        String s = name.replace(" ","");
        for (Product product : productList){
             if (product.getEntityName().replace(" ","").equalsIgnoreCase(s))
                return true;
        }

        return false;
    }

}
