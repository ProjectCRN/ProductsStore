package com.netcracker.crm.services;

import com.netcracker.crm.entity.serviceEntity.Cart;
import com.netcracker.crm.entity.serviceEntity.CartItem;
import com.netcracker.crm.entity.serviceEntity.Product;

/**
 * Created by Nastya on 11/22/2016.
 */
public interface ICartService extends IService<Cart> {
    public void addProduct(int productId);
    public Cart getCart();
    public void changeQuantity(int productId,int quantity);
}
