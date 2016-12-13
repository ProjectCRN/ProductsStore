package com.netcracker.crm.services.impl;

import com.netcracker.crm.entity.serviceEntity.ProductFieldsPatterns;
import com.netcracker.crm.services.IPatternsService;
import org.springframework.stereotype.Service;

/**
 * Created by Anton on 09.12.2016.
 */
@Service
public class PatternsServiceImpl implements IPatternsService {

    private ProductFieldsPatterns productFieldsPatterns;

    @Override
    public ProductFieldsPatterns getProductFieldsPatterns() {
        productFieldsPatterns = new ProductFieldsPatterns();

        productFieldsPatterns.setName("^[a-zA-Z][a-zA-Z0-9-_\\. ]{1,20}$");
        productFieldsPatterns.setPrice("\\d+(\\.\\d{0,2})?");
        productFieldsPatterns.setSummary("^[a-zA-Z][a-zA-Z0-9-_\\. ]{5,140}$");
        productFieldsPatterns.setOperatingSystem("^[a-zA-Z][a-zA-Z0-9-_\\. ]{1,20}$");
        productFieldsPatterns.setProcessorSpeed("[0-9.]{1,8}");
        productFieldsPatterns.setCapacity("[0-9.]{1,8}");
        productFieldsPatterns.setDisplay("[0-9.]{1,8}");
        productFieldsPatterns.setHeight("[0-9.]{1,8}");
        productFieldsPatterns.setWidth("[0-9.]{1,8}");
        productFieldsPatterns.setDepth("[0-9.]{1,8}");
        productFieldsPatterns.setWeight("[0-9.]{1,8}");
        productFieldsPatterns.setCamera("[0-9.]{1,8}");
        productFieldsPatterns.setBattery("[0-9.]{1,8}");
        productFieldsPatterns.setSimCard("^[a-zA-Z][a-zA-Z0-9-_\\. ]{1,20}$");
        productFieldsPatterns.setFabricator("^[a-zA-Z][a-zA-Z0-9-_\\. ]{1,20}$");
        productFieldsPatterns.setImageUrl("^(https?://)?(?:[a-z0-9\\-]+\\.)+[a-z]{2,6}(?:/[^/#?]+)+\\.(?:jpg|gif|png)$");

        return productFieldsPatterns;
    }
}
