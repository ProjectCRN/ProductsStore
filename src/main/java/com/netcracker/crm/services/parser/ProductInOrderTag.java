package com.netcracker.crm.services.parser;

import com.google.common.collect.HashBiMap;

import java.util.HashMap;


public class ProductInOrderTag extends AbstractTag {

    public ProductInOrderTag() {
        tags = HashBiMap.create(new HashMap() {{
            put("price", 19);
            put("productid", 20);
            put("orderid", 21);
            put("quantity", 22);
            put("imageurl", 23);
            put("summary", 24);
        }});
        typeName = "ProductInOrder";
    }
}
