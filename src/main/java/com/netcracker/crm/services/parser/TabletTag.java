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
            put("price", 40);
            put("summary", 41);
            put("operatingsystem", 42);
            put("processorspeed", 43);
            put("capacity", 44);
            put("display", 45);
            put("height", 46);
            put("width", 47);
            put("depth", 48);
            put("weight", 49);
            put("camera", 50);
            put("battery", 51);
            put("simcard", 52);
            put("imageurl", 53);
            put("fabricator", 54);
        }});
        typeName = "Tablet";
    }
}
