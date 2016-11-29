package com.netcracker.crm.entity.serviceEntity;

import com.netcracker.crm.entity.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nastya on 11/22/2016.
 */

public class Cart extends AbstractEntity {
    private List<CartItem> cartItems;
    private int userId;
    private int total;

    public Cart(int id) {
        cartItems=new ArrayList<>();
        userId=id;
        total=0;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        String str="UserID="+userId+"\n"+"Total="+total+"\n";
        for(CartItem item : cartItems){
            str+="\n"+item.toString();
        }
        return str;
    }
    public void addCartItem(CartItem cartItem){
        for(CartItem item : cartItems)
        {
            if(item.getProduct().getId()==cartItem.getProduct().getId())
            {
                item.incQuantity();
                return;
            }
        }
        cartItems.add(cartItem);
    }
    public void updateCartItem(int index,CartItem cartItem){
        cartItems.set(index, cartItem);
    }

    public void deleteCartItem(CartItem cartItem){
        if(cartItem.getQuantity()==1)
            cartItems.remove(cartItem);
        else for(CartItem item : cartItems)
        {
            if(item.getProduct().getId()==cartItem.getProduct().getId())
            {
                item.decQuantity();
                return;
            }
        }
    }
    public int countTotal(){
        total=0;
        for(CartItem item : cartItems){
            total+=(item.getProduct().getPrice() * item.getQuantity());
        }
        return total;
    }
}
