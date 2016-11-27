package com.netcracker.crm.services.parser;

import com.google.common.collect.HashBiMap;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by egor on 27.11.2016.
 */
@Component("telphoneTag")
public class TelephoneTag extends AbstractTag{
    private TelephoneTag(){
        tags = HashBiMap.create(new HashMap(){{
            put("price", 20);
            put("summary", 21);
            put("operatingSystem", 22);
            put("processorSpeedGHz", 23);
            put("capacityGB", 24);
            put("displayInch", 25);
            put("heightMM", 26);
            put("widthMM", 27);
            put("depthMM", 28);
            put("weightGrams", 29);
            put("cameraMP", 30);
            put("batteryHours", 31);
            put("simCard", 32);
            put("quantity", 33);
            put("imageURL", 34);
            put("fabricator", 35);
        }});

    }
}
