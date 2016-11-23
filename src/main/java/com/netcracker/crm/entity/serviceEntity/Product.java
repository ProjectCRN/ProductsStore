package com.netcracker.crm.entity.serviceEntity;


import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;

import java.util.List;

public class Product extends Entity {

    private String productType;
    private double price;
    private String summary;
    private int orderNumber; //0 - не в заказе

    public Product() {
    }


    public Product(Entity entity) {
        this(entity.getEntityName(), entity.getisActive() == 1 ? true : false,
                entity.getEntityTypeName(), entity.getEntityUserId(), entity.getValueList());
        setId(entity.getId());
        setAtributeValueMap(entity.getAtributeValueMap());
        if (getAtributeValueMap() != null) {
            for (int i = 0; i < getAtributeValueMap().size(); i++) {
                if (getAtributeValueMap().get(i).getKey().getAtributeName().equals("Price")) {
                    price = Double.parseDouble(getAtributeValueMap().get(i).getValue().getValue());
                }
                else if (getAtributeValueMap().get(i).getKey().getAtributeName().equals("Summary")) {
                    summary = getAtributeValueMap().get(i).getValue().getValue();
                }
                else if (getAtributeValueMap().get(i).getKey().getAtributeName().equals("OrderNumber")) {
                    summary = getAtributeValueMap().get(i).getValue().getValue();
                }
            }
        }
    }

    public Product(String name, boolean isActive, String productType, int userId,
                   List<Value> vList) {
        super(name, isActive, EntityType.valueOf(productType).getTypeId(), userId, vList);
        this.productType = productType;
    }
    public Product(int id, String name, boolean isActive, String productType, int userId,
                   List<Value> vList) {
        super(name, isActive, EntityType.valueOf(productType).getTypeId(), userId, vList);
        setId(id);
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id='" + getId() + '\'' +
                ", name='" + getEntityName() + '\'' +
                ", price='" + price + '\'' +
                ", summary='" + summary + '\'' +
                ", productType='" + productType + '\'' + "}";
    }

}