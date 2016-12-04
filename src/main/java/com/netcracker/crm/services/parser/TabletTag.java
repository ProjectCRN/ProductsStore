package com.netcracker.crm.services.parser;

import com.google.common.collect.HashBiMap;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by egor on 27.11.2016.
 */

public class TabletTag extends AbstractTag {
    public TabletTag() {
        tags = HashBiMap.create(new HashMap(){{
            put("price", 38);
            put("summary", 39);
            put("operatingsystem", 40);
            put("processorspeed", 41);
            put("capacity", 42);
            put("display", 43);
            put("height", 44);
            put("width", 45);
            put("depth", 46);
            put("weight", 47);
            put("camera", 48);
            put("battery", 49);
            put("simcard", 50);
            put("imageurl", 51);
            put("fabricator", 52);
        }});
        typeName = "Tablet";
    }
}
