package com.netcracker.crm.services;

import com.netcracker.crm.entity.serviceEntity.Cart;

/**
 * Created by Nastya on 11/22/2016.
 */
public interface ICartService extends IService<Cart> {
     void addProduct(int productId);
     Cart getCart();
     void changeQuantity(int productId, int quantity);
     int countTotal();
}
