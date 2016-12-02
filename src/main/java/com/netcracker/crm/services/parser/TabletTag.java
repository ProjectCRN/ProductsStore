package com.netcracker.crm.services.parser;

import com.google.common.collect.HashBiMap;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by egor on 27.11.2016.
 */

public class TabletTag extends AbstractTag {
    private TabletTag() {
        tags = HashBiMap.create(new HashMap(){{
            put("price", 38);
            put("summary", 39);
            put("operatingSystem", 40);
            put("processorSpeedGHz", 41);
            put("capacityGB", 42);
            put("displayInch", 43);
            put("heightMM", 44);
            put("widthMM", 45);
            put("depthMM", 46);
            put("weightGrams", 47);
            put("cameraMP", 48);
            put("batteryHours", 49);
            put("simCard", 50);
            put("imageURL", 51);
            put("fabricator", 52);
        }});
    }
}
