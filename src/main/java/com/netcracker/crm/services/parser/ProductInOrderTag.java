package com.netcracker.crm.services.parser;

import com.google.common.collect.HashBiMap;

import java.util.HashMap;

/**
 * Created by οκ on 04.12.2016.
 */
public class ProductInOrderTag extends AbstractTag {

    public ProductInOrderTag() {
        tags = HashBiMap.create(new HashMap() {{
            put("price", 19);
            put("productid", 20);
            put("orderid", 21);
            put("quantity", 22);
        }});
        typeName = "ProductInOrder";
    }
}
