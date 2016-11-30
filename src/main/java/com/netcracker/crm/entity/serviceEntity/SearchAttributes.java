package com.netcracker.crm.entity.serviceEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ксения on 29.11.2016.
 */
public class SearchAttributes {
    private String minPrice;
    private String maxPrice;
    private String minCapacity;
    private String maxCapacity;
    private String minBattery;
    private String maxBattery;
    private String name;
    private String type;
    private static List<String> types;
    private int typeId;
    private String attribute;
    private String operators;
    private String values;

    public SearchAttributes() {
        if(types == null)
        {
            types = new ArrayList<String>();
            types.add("Telephone");
            types.add("Tablet");
            typeId = 8;
            attribute = "";
            operators = "";
            values = "";
        }
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(String minCapacity) {
        this.minCapacity = minCapacity;
    }

    public String getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(String maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getMinBattery() {
        return minBattery;
    }

    public void setMinBattery(String minBattery) {
        this.minBattery = minBattery;
    }

    public String getMaxBattery() {
        return maxBattery;
    }

    public void setMaxBattery(String maxBattery) {
        this.maxBattery = maxBattery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static List<String> getTypes() {
        return types;
    }

    public static void setTypes(List<String> types) {
        SearchAttributes.types = types;
    }

    public int getTypeId() {
        if(!(typeId==8 || typeId ==9))
            return 8;
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getOperators() {
        return operators;
    }

    public void setOperators(String operators) {
        this.operators = operators;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
