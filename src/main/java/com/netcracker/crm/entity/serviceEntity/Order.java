package com.netcracker.crm.entity.serviceEntity;

import com.netcracker.crm.entity.*;
import javafx.util.Pair;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Nastya on 11/22/2016.
 */
public class Order extends Entity {

//    private String name;    //orderNumber like {id}OR
//    private boolean isActive;
//    private final String entityType = "Order";
//    private int userId;
//    private List<Pair<Atribute, Value>> atributeValueMap;

    private String orderNumber = "";
    private String contactName = "";
    private String contactPhone = "";
    private String contactAddress = "";
    private int total;
    private Date createdDate;
    private Date paidDate;
    private Cart cart;
    private String description = "";
    private final static int ORDERTYPE = 7;

    public Order() {
    }

    public Order(Entity entity) {
        super(entity.getId(), entity.getEntityName(), entity.getisActive() == 1 ? true : false,
                entity.getEntityTypeId(), entity.getEntityTypeName(), entity.getEntityUserId());
        setAtributeValueMap(entity.getAtributeValueMap());
        if (getAtributeValueMap() != null) {
            for (int i = 0; i < getAtributeValueMap().size(); i++) {
                String atributeName = getAtributeValueMap().get(i).getKey().getAtributeName();
                String atributeValue = getAtributeValueMap().get(i).getValue().getValue();
                DateFormat df1 = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy");
                //DateFormat df2 = new SimpleDateFormat("EE MMM dd yyyy");
                switch (atributeName) {
                    case "Order Number":
                        orderNumber = atributeValue;
                        break;
                    case "Contact Name":
                        contactName = atributeValue;
                        break;
                    case "Contact Phone":
                        contactPhone = atributeValue;
                        break;
                    case "Contact Adress":
                        contactAddress = atributeValue;
                        break;
                    case "Total":
                        total = Integer.parseInt(atributeValue);
                        break;
                    case "Created Date":
                        try {
                            createdDate = df1.parse(atributeValue);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "Paid Date":
                        try {
                            createdDate = df1.parse(atributeValue);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "Order Description":
                        description = atributeValue;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public Order(int id, String name, boolean isActive,
                 int userId) {
        super(id, name, isActive, ORDERTYPE,
                "Order", userId);
    }

    public Order(String name, boolean isActive, int userId) {
        super(name, isActive, ORDERTYPE, userId);
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        setValueInList("OrderNumber", orderNumber);
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
        setValueInList("ContactName", contactName);
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
        setValueInList("ContactPhone", contactPhone);
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
        setValueInList("ContactAdress", contactAddress);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        setValueInList("Total", String.valueOf(total));
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        setValueInList("CreatedDate", createdDate.toString());
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
        setValueInList("PaidDate", paidDate.toString());
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//        setValueInList("Description", description);
//    }

    public void setByUser(User user) {
        setContactName(user.getUserName());
        setContactPhone(user.getContactPhone());
        setContactAddress(user.getContactAddress());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        if (!super.equals(o)) return false;

        Order order = (Order) o;

        if (getTotal() != order.getTotal()) return false;
        if (getOrderNumber() != null ? !getOrderNumber().equals(order.getOrderNumber()) : order.getOrderNumber() != null)
            return false;
        if (getContactName() != null ? !getContactName().equals(order.getContactName()) : order.getContactName() != null)
            return false;
        if (getContactPhone() != null ? !getContactPhone().equals(order.getContactPhone()) : order.getContactPhone() != null)
            return false;
        if (getContactAddress() != null ? !getContactAddress().equals(order.getContactAddress()) : order.getContactAddress() != null)
            return false;
        if (getCreatedDate() != null ? !getCreatedDate().equals(order.getCreatedDate()) : order.getCreatedDate() != null)
            return false;
        if (getPaidDate() != null ? !getPaidDate().equals(order.getPaidDate()) : order.getPaidDate() != null)
            return false;
        return !(getCart() != null ? !getCart().equals(order.getCart()) : order.getCart() != null);

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getOrderNumber() != null ? getOrderNumber().hashCode() : 0);
        result = 31 * result + (getContactName() != null ? getContactName().hashCode() : 0);
        result = 31 * result + (getContactPhone() != null ? getContactPhone().hashCode() : 0);
        result = 31 * result + (getContactAddress() != null ? getContactAddress().hashCode() : 0);
        result = 31 * result + getTotal();
        result = 31 * result + (getCreatedDate() != null ? getCreatedDate().hashCode() : 0);
        result = 31 * result + (getPaidDate() != null ? getPaidDate().hashCode() : 0);
        result = 31 * result + (getCart() != null ? getCart().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String str = "Order{" +
                "name='" + getEntityName() + '\'' +
                ", isActive=" + getisActive() +
                ", entityType='" + getEntityTypeName() + '\'' +
                ", userId=" + getEntityUserId() +
                '}';
        if (getAtributeValueMap() != null) {
            for (Pair<Atribute, Value> item : getAtributeValueMap()) {
                str += "\n" + item.getKey().toString();
                str += ": " + item.getValue().toString();
            }
        }
        if(cart!=null) {
            str += "\n" + cart.toString();
        }
        return str;
    }

}