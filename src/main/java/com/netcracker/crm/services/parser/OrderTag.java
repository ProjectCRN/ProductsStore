package com.netcracker.crm.services.parser;

import com.google.common.collect.HashBiMap;

import java.util.HashMap;

/**
 * Created by  on 30.11.2016.
 */
public class OrderTag extends AbstractTag{
    public OrderTag() {
        tags = HashBiMap.create(new HashMap() {{
            put("orderNumber", 12);
            put("contactname", 13);
            put("contactphone", 14);
            put("contactadress", 15);
            put("total", 16);
            put("createddate", 17);
            put("paiddate", 18);
        }});
        typeName = "Order";
    }
}
