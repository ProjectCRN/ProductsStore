package com.netcracker.crm.entity.serviceEntity;


import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Value;
import javafx.util.Pair;

import java.util.List;

public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private String productType;
    private List<Pair<Atribute,Value>> atributeValueMap;


    public Product() {
    }

    public Product(Integer id, String name, Integer price, String productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public Product(Integer id, String name, Integer price, String productType, List<Pair<Atribute, Value>> atributeValueMap) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.atributeValueMap = atributeValueMap;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!getId().equals(product.getId())) return false;
        if (!getName().equals(product.getName())) return false;
        if (!getPrice().equals(product.getPrice())) return false;
        if (!getProductType().equals(product.getProductType())) return false;
        return !(getAtributeValueMap() != null ? !getAtributeValueMap().equals(product.getAtributeValueMap()) :
                product.getAtributeValueMap() != null);

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getProductType().hashCode();
        result = 31 * result + (getAtributeValueMap() != null ? getAtributeValueMap().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productType='" + productType + '\'' +
                ", atributeValueMap=" + atributeValueMap +
                '}';
    }
}
