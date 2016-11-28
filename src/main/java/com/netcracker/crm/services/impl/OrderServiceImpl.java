package com.netcracker.crm.services.impl;

import com.netcracker.crm.dao.IEntityDao;
import com.netcracker.crm.dao.impl.EntityDaoImpl;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.serviceEntity.Order;
import com.netcracker.crm.services.AbstractService;
import com.netcracker.crm.services.IOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nastya on 11/22/2016.
 */
@Service("orderService")
public class OrderServiceImpl extends AbstractService<Order> implements IOrderService {

    @Autowired
    private IEntityDao entityDao;
    private static Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @Override
    public void update(int id, String entityName, int isActive, int userId, List<Value> valuesArr) {

    }

    @Override
    public List<Order> getList(int typeId, String atributesId, String values, String operators) {
        return null;
    }

    @Override
    public int add(Order abstractEntity) {
        return 0;
    }

    @Override
    public Order getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

}
