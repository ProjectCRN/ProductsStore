package com.netcracker.crm.entity.controllerEntity;

import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
/**
 * Created by Ксения on 15.11.2016.
 */
public class Order {
    private int id;
    private int total;

    @Size(min=3, max=20, message = "Username must be between 3 and 20 characters long")
    private String name;

    @Size(min=10, message = "Address must be longer then 10 characters")
    private String address;

   // @Pattern(regexp="^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$", message="Invalid phone number")
    private String phone;

    //@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message="Invalid email address")
    private String email;

    private String comments;

    private List<CartItem> cartItemList;

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getName() {

        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getComments() {
        return comments;
    }

    public int getTotal() {

        return total;
    }
}
