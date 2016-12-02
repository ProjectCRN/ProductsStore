package com.netcracker.crm.services.parser;

import com.google.common.collect.HashBiMap;

import java.util.HashMap;

/**
 * Created by  on 30.11.2016.
 */
public class OrderTag extends AbstractTag{
    private OrderTag() {
        tags = HashBiMap.create(new HashMap() {{
            put("orderNumber", 12);
        }});
    }
}
