package com.netcracker.crm.services;

import com.netcracker.crm.entity.serviceEntity.Cart;

public interface ICartService extends IService<Cart> {
    void createCart(int userId);

    void addProduct(int productId);

    Cart getCart();

    void changeQuantity(int productId, int quantity);

    int countTotal();

    void clearCart();
}
