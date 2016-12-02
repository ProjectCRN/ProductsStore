package com.netcracker.crm.services.parser;

import com.google.common.collect.HashBiMap;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by egor on 27.11.2016.
 */

public class TelephoneTag extends AbstractTag {
    private TelephoneTag(){
        tags = HashBiMap.create(new HashMap(){{
            put("price", 23);
            put("summary", 24);
            put("operatingSystem", 25);
            put("processorSpeedGHz", 26);
            put("capacityGB", 27);
            put("displayInch", 28);
            put("heightMM", 29);
            put("widthMM", 30);
            put("depthMM", 31);
            put("weightGrams", 32);
            put("cameraMP", 33);
            put("batteryHours", 34);
            put("simCard", 35);
            put("imageURL", 36);
            put("fabricator", 37);
        }});

    }
}
