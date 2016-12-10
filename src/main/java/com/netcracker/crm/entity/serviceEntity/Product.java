package com.netcracker.crm.entity.serviceEntity;


import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;
import javafx.util.Pair;

import java.util.List;

public class Product extends Entity {

//    private String name;    //название телефона или планшета
//    private boolean isActive;
//    private String productType; //телефон или планшет
//    private int userId;
//    private List<Pair<Atribute, Value>> atributeValueMap;  //атрибуты телефона (камера и т.п.)

    private static final long serialVersionUID = 1L;
    private double price;
    private String summary;
    private int orderId; //0 - не в заказе, толкьо у productInOrder
    private String imageUrl;
    private int quantity;  //толкьо у productInOrder
    private String fabricator;

    public Product() {
    }

    public Product(Entity entity) {
        super(entity.getId(), entity.getEntityName(), entity.getisActive() == 1 ? true : false,
                entity.getEntityTypeId(), entity.getEntityTypeName(), entity.getEntityUserId());
        setAtributeValueMap(entity.getAtributeValueMap());
        setValueListByMap(getAtributeValueMap());
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
                        if (atributeValue != null && atributeValue.equals("URL"))
                            setImageUrl("/resources/img/img_phone.jpg");
                        break;
                    case "Quantity":
                        quantity = Integer.parseInt(atributeValue);
                        break;
                    case "Fabricator":
                        fabricator = atributeValue;
                    default:
                        break;
                }
            }
        }
    }

    public Product(String name, boolean isActive) {
        setEntityName(name);
        setIsActive(isActive);
    }

    public Product(int id, String name, boolean isActive,
                   int productTypeId, String productTypeName, int userId) {
        super(id, name, isActive, productTypeId, productTypeName, userId);
    }

    public Product(String name, boolean isActive, int productTypeId, int userId) {
        super(name, isActive, productTypeId, userId);
    }

    public Product(String name, boolean isActive, int productTypeId, int userId, List<Value> valueList) {
        super(name, isActive, productTypeId, userId, valueList);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        setValueInList("price", String.valueOf(price));
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
        setValueInList("summary", summary);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
        setValueInList("orderid", String.valueOf(orderId));
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        setValueInList("imageurl", imageUrl);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        setValueInList("quantity", String.valueOf(quantity));
    }

    public String getFabricator() {
        return fabricator;
    }

    public void setFabricator(String fabricator) {
        this.fabricator = fabricator;
        setValueInList("fabricator", fabricator);
    }

    public String getCapacity() {
        return getValueFromList(getAtributeId("capacity"));
    }

    public String getBattery() {
        return getValueFromList(getAtributeId("battery"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        if (getOrderId() != product.getOrderId()) return false;
        if (getQuantity() != product.getQuantity()) return false;
        if (getSummary() != null ? !getSummary().equals(product.getSummary()) : product.getSummary() != null)
            return false;
        if (getImageUrl() != null ? !getImageUrl().equals(product.getImageUrl()) : product.getImageUrl() != null)
            return false;
        return !(getFabricator() != null ? !getFabricator().equals(product.getFabricator()) : product.getFabricator() != null);

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
        result = 31 * result + getQuantity();
        result = 31 * result + (getFabricator() != null ? getFabricator().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String str = "Product{" +
                "id='" + getId() + '\'' +
                ", name='" + getEntityName() + '\'' +
                ", user='" + getEntityUserId() + '\'' +
                ", type='" + getEntityTypeName() + '\'' + "}";
        if (getAtributeValueMap() != null) {
            for (Pair<Atribute, Value> item : getAtributeValueMap()) {
                str += "\n" + item.getKey().toString();
                str += ": " + item.getValue().toString();
            }
        }
        return str;
    }

    public String ValuestoString() {
        String str = "";
        if (getAtributeValueMap() != null) {
            for (Pair<Atribute, Value> item : getAtributeValueMap()) {
                if (!item.getKey().toString().equals("ImageURL")) {
                    str += "\n" + item.getKey().toString();
                    str += ": " + item.getValue().toString() + "<br>";
                }
            }
        }
        return str;
    }
}