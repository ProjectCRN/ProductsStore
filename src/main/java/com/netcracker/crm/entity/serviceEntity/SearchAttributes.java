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
    private String numPerPage;

    private int typeId;
    private String attribute;
    private String operators;
    private String values;

    public SearchAttributes() { numPerPage="2";   }

    public String getLists() {return attribute+" | "+operators+" | "+values;}

    public String getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(String numPerPage) {
        this.numPerPage = numPerPage;
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

    public int getTypeId() { return typeId; }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getAttribute() {
        if(attribute == null) return "";
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getOperators() {
        if(operators == null) return "";
        return operators;
    }

    public void setOperators(String operators) {
        this.operators = operators;
    }

    public String getValues() {
        if(values == null) return "";
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchAttributes that = (SearchAttributes) o;

        if (typeId != that.typeId) return false;
        if (minPrice != null ? !minPrice.equals(that.minPrice) : that.minPrice != null) return false;
        if (maxPrice != null ? !maxPrice.equals(that.maxPrice) : that.maxPrice != null) return false;
        if (minCapacity != null ? !minCapacity.equals(that.minCapacity) : that.minCapacity != null) return false;
        if (maxCapacity != null ? !maxCapacity.equals(that.maxCapacity) : that.maxCapacity != null) return false;
        if (minBattery != null ? !minBattery.equals(that.minBattery) : that.minBattery != null) return false;
        if (maxBattery != null ? !maxBattery.equals(that.maxBattery) : that.maxBattery != null) return false;
        if (numPerPage != null ? !numPerPage.equals(that.numPerPage) : that.numPerPage != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(type != null ? !type.equals(that.type) : that.type != null);

    }

    @Override
    public int hashCode() {
        int result = minPrice != null ? minPrice.hashCode() : 0;
        result = 31 * result + (maxPrice != null ? maxPrice.hashCode() : 0);
        result = 31 * result + (minCapacity != null ? minCapacity.hashCode() : 0);
        result = 31 * result + (maxCapacity != null ? maxCapacity.hashCode() : 0);
        result = 31 * result + (minBattery != null ? minBattery.hashCode() : 0);
        result = 31 * result + (maxBattery != null ? maxBattery.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + typeId;
        return result;
    }
}
