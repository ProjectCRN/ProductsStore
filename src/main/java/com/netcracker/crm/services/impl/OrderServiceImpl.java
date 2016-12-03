package com.netcracker.crm.services.impl;

import com.netcracker.crm.dao.IEntityDao;
import com.netcracker.crm.dao.IUserDao;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.enums.ProductInOrderAtribute;
import com.netcracker.crm.entity.serviceEntity.*;
import com.netcracker.crm.services.AbstractService;
import com.netcracker.crm.services.IOrderService;
import com.netcracker.crm.services.IProductService;
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
import java.util.ArrayList;
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
    private final static String orderIdStr = "OrderID";

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
                //добавляем entity с типом ProductInOrder
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
            Cart cart = new Cart(order.getEntityUserId(), order.getTotal());
            String quantityId = getAtributeIdByTypeId
                    (EntityType.valueOf(productInOrderStr).getTypeId(), "Quantity");
            String priceId = getAtributeIdByTypeId
                    (EntityType.valueOf(productInOrderStr).getTypeId(), "Price");
            String prodId = getAtributeIdByTypeId
                    (EntityType.valueOf(productInOrderStr).getTypeId(), "ProductID");
            List<Entity> list = entityDao.getList(EntityType.valueOf(productInOrderStr).getTypeId(),
                    String.valueOf(ProductInOrderAtribute.valueOf(orderIdStr).getAtributeId()),
                    String.valueOf(order.getId()), "=", quantityId + "," + priceId+ "," + prodId);
            for (Entity e : list) {
                Product prod = new Product(e);
                cart.addCartItem(new CartItem(prod, prod.getQuantity()));
            }
            order.setCart(cart);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getById " + order.toString());
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return order;
    }

    @Override
    public List<Order> getListForUser(int userId) {
        List<Order> orderList;
        try {
            List<Entity> list = entityDao.getByUserAndType(userId, EntityType.Order.getTypeId(),
                    getAtributeIdByTypeId(EntityType.Order.getTypeId(), "CreatedDate"));
            orderList = new ArrayList<>(list.size());
            for (Entity e : list) {
                orderList.add(new Order(e));
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getListForUser for Order");
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return orderList;
    }

    @Override
    public void update(int id, String entityName, int isActive, int userId, List<Value> valuesArr) {
        try {
            entityDao.update(id, entityName, isActive, userId, valuesArr);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " update order #" + id);
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
    }

    @Override
    public List<Order> getList(int typeId, String atributesId, String values, String operators, int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public void updateByOrder(Order order) {
        try {
            entityDao.updateByEntity(order);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " update order #" + order.getId());

        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
    }

    @Override
    public void delete(int id) {
        try {
            entityDao.delete(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " delete order #" + id);
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
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