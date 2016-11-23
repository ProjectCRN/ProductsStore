package com.netcracker.crm.entity.controllerEntity.controllerService;

import com.netcracker.crm.entity.controllerEntity.Cart;
import com.netcracker.crm.entity.controllerEntity.CartItem;

import java.util.List;

/**
 * Created by Ксения on 22.11.2016.
 */

public class CartService {
    private static Cart cart;

    public CartService() {
        if(cart == null)
            cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Boolean add(int id){
        return cart.add(id);
    }

    public Boolean delete(int id){
        return cart.delete(id);
    }

    public int getTotal(){
        return cart.getTotal();
    }

    public List<CartItem> getListCartItem(){
        return cart.getListCartItem();
    }
}
