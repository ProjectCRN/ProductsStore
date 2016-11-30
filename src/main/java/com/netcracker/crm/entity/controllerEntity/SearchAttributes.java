package com.netcracker.crm.entity.controllerEntity;

/**
 * Created by Ксения on 25.11.2016.
 */
public class SearchAttributes {
    private String minPrice;
    private String maxPrice;
    private String minSize;
    private String maxSize;
    private String minRam;
    private String maxRam;
    private String name;
    private String type;

    public SearchAttributes() {
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

    public String getMinSize() {
        return minSize;
    }

    public void setMinSize(String minSize) {
        this.minSize = minSize;
    }

    public String getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public String getMinRam() {
        return minRam;
    }

    public void setMinRam(String minRam) {
        this.minRam = minRam;
    }

    public String getMaxRam() {
        return maxRam;
    }

    public void setMaxRam(String maxRam) {
        this.maxRam = maxRam;
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

    @Override
    public String toString() {
        return "SearchAttributes{" +
                "minPrice='" + minPrice + '\'' +
                ", maxPrice='" + maxPrice + '\'' +
                ", minSize='" + minSize + '\'' +
                ", maxSize='" + maxSize + '\'' +
                ", minRam='" + minRam + '\'' +
                ", maxRam='" + maxRam + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
