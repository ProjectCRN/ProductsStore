package com.netcracker.crm.entity.serviceEntity;

import com.netcracker.crm.entity.AbstractEntity;
import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Value;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nastya on 11/22/2016.
 */
public class Cart extends AbstractEntity {
    private List<CartItem> cartItems;
    private int userId;


    public Cart(int id) {
        cartItems=new ArrayList<>();
        userId=id;
    }


    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        String str="UserID="+userId+"\n";
        for(CartItem item : cartItems){
            str+="\n"+item.toString();}
        return str;
    }
    public void addCartItem(CartItem cartItem){
        cartItems.add(cartItem);
    }
    public void updateCartItem(int index,CartItem cartItem){
        cartItems.set(index, cartItem);
    }
    public void deleteCartItem(CartItem cartItem){
        cartItems.remove(cartItem);
    }
}
