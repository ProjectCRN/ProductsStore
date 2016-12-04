package com.netcracker.crm.services.parser;

import com.google.common.collect.HashBiMap;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by egor on 27.11.2016.
 */

public class TypeAttribute extends AbstractTag {
    public TypeAttribute() {
        tags = HashBiMap.create(new HashMap(){{
            put("order", 7);
            put("productinorder", 8);
            put("telephone", 9);
            put("tablet", 10);
            put("smartwatch", 11);
        }});
    }
}
