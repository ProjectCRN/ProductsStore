package com.netcracker.crm.entity.serviceEntity;


import com.netcracker.crm.entity.AbstractEntity;
import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

//возможно наследовать от entity
public class Product extends AbstractEntity {
    private String name;    //название телефона или планшета
    private boolean isActive;
    private String productType; //телефон или планшет
    private int userId;
    private double price;
    private String summary;
    private int orderId; //0 - не в заказе
    private String imageUrl;
    private int quantity;
    private List<Pair<Atribute, Value>> atributeValueMap;  //атрибуты телефона (камера и т.п.)


    public Product() {
    }

    public Entity toEntity() {
        Entity entity = new Entity(getId(), name, isActive,
                EntityType.valueOf(productType).getTypeId(), productType, userId);
        entity.setAtributeValueMap(atributeValueMap);
        return entity;
    }

    public Product(Entity entity) {
        this(entity.getId(), entity.getEntityName(), entity.getisActive() == 1 ? true : false,
                entity.getEntityTypeName(), entity.getEntityUserId(), entity.getAtributeValueMap());
        if (atributeValueMap != null) {
            for (int i = 0; i < atributeValueMap.size(); i++) {
                String atributeName = atributeValueMap.get(i).getKey().getAtributeName();
                String atributeValue = atributeValueMap.get(i).getValue().getValue();
                switch (atributeName) {
                    case "Price":
                        price = Double.parseDouble(atributeValue);
                        break;
                    case "Summary":
                        summary = atributeValue;
                        break;
                    case "OrderID":
                        orderId = Integer.parseInt(atributeValue);
                        break;
                    case "ImageURL":
                        imageUrl = atributeValue;
                        break;
                    case "Quantity":
                        quantity = Integer.parseInt(atributeValue);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    //поля из entity и атрибуты
    public Product(int id, String name, boolean isActive, String productType, int userId, List<Pair<Atribute, Value>> avMap) {
        super(id);
        this.name = name;
        this.isActive = isActive;
        this.productType = productType;
        this.userId = userId;
        this.atributeValueMap = avMap;
    }

    public Product(int id, String name, boolean isActive, String productType, int userId, int price, String summary) {
        super(id);
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.isActive = isActive;
        this.userId = userId;
        this.summary = summary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public List<Pair<Atribute, Value>> getAtributeValueMap() {
        return atributeValueMap;
    }

    public void setAtributeValueMap(List<Pair<Atribute, Value>> atributeValueMap) {
        this.atributeValueMap = atributeValueMap;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (isActive() != product.isActive()) return false;
        if (getUserId() != product.getUserId()) return false;
        if (getPrice() != product.getPrice()) return false;
        if (getOrderId() != product.getOrderId()) return false;
        if (!getName().equals(product.getName())) return false;
        if (!getProductType().equals(product.getProductType())) return false;
        if (getSummary() != null ? !getSummary().equals(product.getSummary()) : product.getSummary() != null)
            return false;
        return !(getAtributeValueMap() != null ? !getAtributeValueMap().equals(product.getAtributeValueMap()) : product.getAtributeValueMap() != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + getName().hashCode();
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + getProductType().hashCode();
        result = 31 * result + getUserId();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getSummary() != null ? getSummary().hashCode() : 0);
        result = 31 * result + getOrderId();
        result = 31 * result + (getAtributeValueMap() != null ? getAtributeValueMap().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", productType='" + productType + '\'' + "}";
    }

    public List<Value> getValueList() {
        List<Value> values = new ArrayList<>();
        for (Pair<Atribute, Value> p : atributeValueMap) {
            values.add(p.getValue());
        }
        return values;
        //return valueList;
    }
}