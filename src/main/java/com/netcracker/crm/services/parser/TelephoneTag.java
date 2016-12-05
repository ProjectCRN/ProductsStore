package com.netcracker.crm.services.parser;

import com.google.common.collect.HashBiMap;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by egor on 27.11.2016.
 */

public class TelephoneTag extends AbstractTag {
    public TelephoneTag(){
        tags = HashBiMap.create(new HashMap(){{
            put("price", 23);
            put("summary", 24);
            put("operatingsystem", 25);
            put("processorspeed", 26);
            put("capacity", 27);
            put("display", 28);
            put("height", 29);
            put("width", 30);
            put("depth", 31);
            put("weight", 32);
            put("camera", 33);
            put("battery", 34);
            put("simcard", 35);
            put("imageurl", 36);
            put("fabricator", 37);
        }});
        typeName = "Telephone";
    }
}
