package com.netcracker.crm.services;

import com.netcracker.crm.entity.serviceEntity.Cart;
import com.netcracker.crm.entity.serviceEntity.Order;

/**
 * Created by Nastya on 11/22/2016.
 */
public interface IOrderService extends IEntityService<Order> {
    public Order makeOrderByCart(Cart cart);
}
