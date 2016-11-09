package com.netcracker.crm.entity.controllerEntity;


public class Product {
    private Integer id;
    private String name;
    private Integer price;

    public Product(int id, String name, int price) {
        setId(id);
        setName(name);
        setPrice(price);
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
