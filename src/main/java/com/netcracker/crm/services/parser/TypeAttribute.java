package com.netcracker.crm.services.parser;

import com.google.common.collect.HashBiMap;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by egor on 27.11.2016.
 */
@Component("typeAttribute")
public class TypeAttribute extends AbstractTag {
    private TypeAttribute() {
        tags = HashBiMap.create(new HashMap(){{
            put("telephone", 8);
            put("tablet", 9);
            put("smartWatch", 10);
        }});
    }
}