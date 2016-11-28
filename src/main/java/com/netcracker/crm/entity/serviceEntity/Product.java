package com.netcracker.crm.entity.serviceEntity;


import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;

import java.util.List;

public class Product extends Entity {
//    private String name;    //название телефона или планшета
//    private boolean isActive;
//    private String productType; //телефон или планшет
//    private int userId;
    private double price;
    private String summary;
    private int orderId; //0 - не в заказе
    private String imageUrl;
    private int quantity;
//    private List<Pair<Atribute, Value>> atributeValueMap;  //атрибуты телефона (камера и т.п.)


    public Product() {
    }

//    public Entity toEntity() {
//        Entity entity = new Entity(getId(), name, isActive,
//                EntityType.valueOf(productType).getTypeId(), productType, userId);
//        entity.setAtributeValueMap(atributeValueMap);
//        return entity;
//    }

    public Product(Entity entity) {
        super(entity.getId(), entity.getEntityName(), entity.getisActive() == 1 ? true : false,
                entity.getEntityTypeId(), entity.getEntityTypeName(), entity.getEntityUserId());
        setAtributeValueMap(entity.getAtributeValueMap());
        if (getAtributeValueMap() != null) {
            for (int i = 0; i < getAtributeValueMap().size(); i++) {
                String atributeName = getAtributeValueMap().get(i).getKey().getAtributeName();
                String atributeValue = getAtributeValueMap().get(i).getValue().getValue();
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

    public Product(int id, String name, boolean isActive,
                   int productTypeId, String productTypeName, int userId) {
        super(id, name, isActive, productTypeId, productTypeName, userId);
    }

    public Product(String name, boolean isActive, int productTypeId, int userId, List<Value> valueList) {
        super(name, isActive, productTypeId, userId, valueList);
    }

//    public Product(int id, String name, boolean isActive, String productType, int userId, int price, String summary) {
//        super(id);
//        this.name = name;
//        this.price = price;
//        this.productType = productType;
//        this.isActive = isActive;
//        this.userId = userId;
//        this.summary = summary;
//    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        if (getOrderId() != product.getOrderId()) return false;
        if (quantity != product.quantity) return false;
        if (getSummary() != null ? !getSummary().equals(product.getSummary()) : product.getSummary() != null)
            return false;
        return !(getImageUrl() != null ? !getImageUrl().equals(product.getImageUrl()) : product.getImageUrl() != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getSummary() != null ? getSummary().hashCode() : 0);
        result = 31 * result + getOrderId();
        result = 31 * result + (getImageUrl() != null ? getImageUrl().hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + getId() + '\'' +
                ", name='" + getEntityName() + '\'' +
                ", price='" + price + '\'' +
                ", productType='" + getEntityTypeName() + '\'' + "}";
    }
}