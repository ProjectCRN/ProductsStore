package com.netcracker.crm.entity.serviceEntity;

import com.netcracker.crm.entity.AbstractEntity;
import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;
import javafx.util.Pair;

import java.util.Date;
import java.util.List;

/**
 * Created by Nastya on 11/22/2016.
 */
public class Order extends AbstractEntity {
    private String name;    //orderNumber
    private boolean isActive;
    private String entityType="Order";
    private int userId;
    private String orderNumber;
    private String contactName;
    private String contactPhone;
    private String contactAdress;
    private int Total;
    private Date createdDate;
    private Date paidDate;

    private Cart cart;
    private List<Pair<Atribute, Value>> atributeValueMap;


    public Order (Cart cart){

    }

    public Order(int id, String entityName, boolean b,  int entityUserId, List<Pair<Atribute, Value>> atributeValueMap) {
        super(id);
        this.name = entityName;
        this.isActive = b;
        this.userId = entityUserId;
        this.atributeValueMap = atributeValueMap;
    }


    public Entity toEntity(){

        Entity entity =  new Entity(getId(), name, isActive, EntityType.valueOf(entityType).getTypeId(), entityType, userId);
        entity.setAtributeValueMap(atributeValueMap);
        return entity;
    }

    public Order(Entity entity) {
        this(entity.getId(), entity.getEntityName(), entity.getisActive() == 1 ? true : false, entity.getEntityUserId(), entity.getAtributeValueMap());

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Pair<Atribute, Value>> getAtributeValueMap() {
        return atributeValueMap;
    }

    public void setAtributeValueMap(List<Pair<Atribute, Value>> atributeValueMap) {
        this.atributeValueMap = atributeValueMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactAdress() {
        return contactAdress;
    }

    public void setContactAdress(String contactAdress) {
        this.contactAdress = contactAdress;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Order order = (Order) o;

        if (isActive != order.isActive) return false;
        if (userId != order.userId) return false;
        if (Total != order.Total) return false;
        if (!name.equals(order.name)) return false;
        if (!entityType.equals(order.entityType)) return false;
        if (!orderNumber.equals(order.orderNumber)) return false;
        if (!contactName.equals(order.contactName)) return false;
        if (!contactPhone.equals(order.contactPhone)) return false;
        if (!contactAdress.equals(order.contactAdress)) return false;
        if (!createdDate.equals(order.createdDate)) return false;
        if (paidDate != null ? !paidDate.equals(order.paidDate) : order.paidDate != null) return false;
        if (!cart.equals(order.cart)) return false;
        return atributeValueMap != null ? atributeValueMap.equals(order.atributeValueMap) : order.atributeValueMap == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + entityType.hashCode();
        result = 31 * result + userId;
        result = 31 * result + orderNumber.hashCode();
        result = 31 * result + contactName.hashCode();
        result = 31 * result + contactPhone.hashCode();
        result = 31 * result + contactAdress.hashCode();
        result = 31 * result + Total;
        result = 31 * result + createdDate.hashCode();
        result = 31 * result + (paidDate != null ? paidDate.hashCode() : 0);
        result = 31 * result + cart.hashCode();
        result = 31 * result + (atributeValueMap != null ? atributeValueMap.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String str ="Order{" +
                "name='" + name + '\'' +
                ", isActive=" + isActive +
                ", entityType='" + entityType + '\'' +
                ", userId=" + userId +
                '}';
        for(Pair<Atribute,Value> item : atributeValueMap){
            str+="\n"+item.getKey().toString();
            str+="\n"+item.getValue().toString();
        }
        str+=cart.toString();
        return str;
    }
}
