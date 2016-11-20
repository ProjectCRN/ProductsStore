package com.netcracker.crm.entity.serviceEntity;


import com.netcracker.crm.entity.AbstractEntity;
import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Value;
import javafx.util.Pair;

import java.util.List;

public class Product extends AbstractEntity{
    private String name;
    private int price;
    private String productType;
    private boolean isActive;
    private int userId;
    private List<Pair<Atribute,Value>> atributeValueMap;


    public Product() {
    }

    public Product(int id, String name, int price, String productType) {
        super(id);
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public Product(int id, String name, int price, String productType, List<Pair<Atribute, Value>> atributeValueMap) {
        super(id);
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.atributeValueMap = atributeValueMap;
    }

    public Product(int id, String name, int price, String productType, boolean isActive,
                   int userId, List<Pair<Atribute, Value>> atributeValueMap) {
        super(id);
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.isActive = isActive;
        this.userId = userId;
        this.atributeValueMap = atributeValueMap;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (getPrice() != product.getPrice()) return false;
        if (isActive() != product.isActive()) return false;
        if (getUserId() != product.getUserId()) return false;
        if (!getName().equals(product.getName())) return false;
        if (!getProductType().equals(product.getProductType())) return false;
        return !(getAtributeValueMap() != null ? !getAtributeValueMap().equals(product.getAtributeValueMap()) : product.getAtributeValueMap() != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPrice();
        result = 31 * result + getProductType().hashCode();
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + getUserId();
        result = 31 * result + (getAtributeValueMap() != null ? getAtributeValueMap().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", productType='" + productType + '\'' +
                ", isActive=" + isActive +
                ", userId=" + userId +
                ", atributeValueMap=" + atributeValueMap +
                '}';
    }
}
