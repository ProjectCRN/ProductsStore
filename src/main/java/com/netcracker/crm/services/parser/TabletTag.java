package com.netcracker.crm.services.parser;

import com.google.common.collect.HashBiMap;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by egor on 27.11.2016.
 */
@Component("tabletTag")
public class TabletTag extends AbstractTag {
    private TabletTag() {
        tags = HashBiMap.create(new HashMap(){{
            put("price", 37);
            put("summary", 38);
            put("operatingSystem", 39);
            put("processorSpeedGHz", 40);
            put("capacityGB", 41);
            put("displayInch", 42);
            put("heightMM", 43);
            put("widthMM", 44);
            put("depthMM", 45);
            put("weightGrams", 46);
            put("cameraMP", 47);
            put("batteryHours", 48);
            put("simCard", 49);
            put("quantity", 50);
            put("imageURL", 51);
            put("fabricator", 52);
        }});
    }
}
