package com.netcracker.crm.services.impl;

import com.netcracker.crm.dao.IEntityDao;
import com.netcracker.crm.dao.IUserDao;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.serviceEntity.*;
import com.netcracker.crm.services.AbstractService;
import com.netcracker.crm.services.IOrderService;
import com.netcracker.crm.services.constants.ServiceConstants;
import com.netcracker.crm.services.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Nastya on 11/22/2016.
 */

public class OrderServiceImpl extends AbstractService<Order> implements IOrderService {

    private IEntityDao entityDao;
    private IUserDao userDao;
    private static Logger logger = LogManager.getLogger(OrderServiceImpl.class);
    private final static String productInOrderStr = "ProductInOrder";
    private final static String productIdStr = "ProductID";

    @Override
    public Order makeOrderByCart(Cart cart) {
        User user = userDao.getById(cart.getUserId());
        Order order = new Order("ordername", true, user.getId());
        order.setCart(cart);
        order.setByUser(user);
        order.setTotal(cart.countTotal());
        LocalDate ld = LocalDate.now();
        Date date = ld.toDate();
        order.setCreatedDate(date);
        order.setPaidDate(date);
        order.setOrderNumber("somenumber");
//        order.setDescription("somedescription");
        return order;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int add(Order order) {
        int id;
        try {
            id = entityDao.add(order);
            for (CartItem item : order.getCart().getCartItems()) {
                Product product = item.getProduct();
                //добавляем entity с типом купленного продукта
                product.setEntityTypeId(EntityType.valueOf(productInOrderStr).getTypeId());
                product.setUserId(order.getEntityUserId());
                product.setQuantity(item.getQuantity());
                product.setOrderId(id);
                product.setValueInList(productIdStr, String.valueOf(product.getId()));
                product.setPrice(product.getPrice());
                entityDao.add(product);
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " add " + order.toString());
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return id;
    }

    @Override
    public Order getById(int id) {
        Order order;
        try {
            order = new Order(entityDao.getById(id));
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getById " + order.toString());
        }
        catch (DaoException exc){
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return order;
    }

    @Override
    public List<Order> getList(int typeId, String atributesId, String values, String operators, int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public void update(int id, String entityName, int isActive, int userId, List<Value> valuesArr) {

    }

    @Override
    public void delete(int id) {

    }

    @Required
    public void setEntityDao(IEntityDao entityDao) {
        this.entityDao = entityDao;
    }

    @Required
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

}
