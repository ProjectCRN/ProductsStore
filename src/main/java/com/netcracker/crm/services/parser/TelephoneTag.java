package com.netcracker.crm.services.parser;

import com.google.common.collect.HashBiMap;
import org.springframework.stereotype.Component;

import java.util.HashMap;


public class TelephoneTag extends AbstractTag {
    public TelephoneTag() {
        tags = HashBiMap.create(new HashMap() {{
            put("price", 25);
            put("summary", 26);
            put("operatingsystem", 27);
            put("processorspeed", 28);
            put("capacity", 29);
            put("display", 30);
            put("height", 31);
            put("width", 32);
            put("depth", 33);
            put("weight", 34);
            put("camera", 35);
            put("battery", 36);
            put("simcard", 37);
            put("imageurl", 38);
            put("fabricator", 39);
        }});
        typeName = "Telephone";
    }
}
