package com.netcracker.crm.services;

import com.netcracker.crm.entity.serviceEntity.Cart;
import com.netcracker.crm.entity.serviceEntity.Order;

import java.util.List;

/**
 * Created by Nastya on 11/22/2016.
 */
public interface IOrderService extends IEntityService<Order> {
    public Order makeOrderByCart(Cart cart);
    public List<Order> getListForUser(int userId);
    public void updateByOrder(Order order);
    public int rowCounter(int typeId, String atributesId, String values, String operators);

}

