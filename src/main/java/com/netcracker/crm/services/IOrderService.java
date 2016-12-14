package com.netcracker.crm.services;

import com.netcracker.crm.entity.serviceEntity.Cart;
import com.netcracker.crm.entity.serviceEntity.Order;

import java.util.List;


public interface IOrderService extends IEntityService<Order> {
    Order makeOrderByCart(Cart cart);

    List<Order> getListForUser(int userId);

    void updateByOrder(Order order);

    int rowCounter(int typeId, String atributesId, String values, String operators, String role);

    List<Order> getList();

}

