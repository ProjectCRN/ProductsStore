package com.netcracker.crm.services.impl;

import com.netcracker.crm.dao.IEntityDao;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.serviceEntity.CartItem;
import com.netcracker.crm.entity.serviceEntity.Order;
import com.netcracker.crm.entity.serviceEntity.Product;
import com.netcracker.crm.services.AbstractService;
import com.netcracker.crm.services.IOrderService;
import com.netcracker.crm.services.constants.ServiceConstants;
import com.netcracker.crm.services.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int add(Order order) {
        int id;
        try {
            id = entityDao.add(order.toEntity());
            for (CartItem item : order.getCart().getCartItems()) {
                Product product = item.getProduct();
                product.setQuantity(item.getQuantity());
                product.setOrderId(id);
                entityDao.add(product);
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " add " + order.toString());
        }catch(DaoException exc){
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return id;
    }


    @Override
    public Order getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

}
