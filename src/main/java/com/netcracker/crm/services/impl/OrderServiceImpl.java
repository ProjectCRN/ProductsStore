package com.netcracker.crm.services.impl;

import com.netcracker.crm.dao.IEntityDao;
import com.netcracker.crm.dao.IUserDao;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.enums.OrderAtribute;
import com.netcracker.crm.entity.enums.ProductInOrderAtribute;
import com.netcracker.crm.entity.serviceEntity.*;
import com.netcracker.crm.services.AbstractService;
import com.netcracker.crm.services.IOrderService;
import com.netcracker.crm.services.constants.ServiceConstants;
import com.netcracker.crm.services.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class OrderServiceImpl extends AbstractService<Order> implements IOrderService {

    private IEntityDao entityDao;
    private IUserDao userDao;
    private static Logger logger = LogManager.getLogger(OrderServiceImpl.class);
    private final static String orderStr = "Order";

    @Override
    public Order makeOrderByCart(Cart cart) {
        User user = userDao.getById(cart.getUserId());
        Order order = new Order("ordername", true, user.getId());
        order.setCart(cart);
        order.setByUser(user);
        order.setTotal(cart.countTotal());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate now = LocalDate.now();
        order.setCreatedDate(dtf.format(now));
        order.setPaidDate(dtf.format(now));
        order.setOrderNumber(order.orderNumberGenerator());
        return order;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int add(Order order) {
        int id;
        try {
            id = entityDao.add(order);
            for (CartItem item : order.getCart().getCartItems()) {
                Product cartProduct = item.getProduct();
                Product product = new Product(cartProduct.getEntityName(), true);
                //добавляем entity с типом ProductInOrder
                product.setEntityTypeId(EntityType.ProductInOrder.getTypeId());
                product.setUserId(order.getEntityUserId());
                product.setQuantity(item.getQuantity());
                product.setOrderId(id);
                product.setValueInList(ProductInOrderAtribute.ProductID.getAtributeId(),
                        String.valueOf(cartProduct.getId()));
                product.setPrice(cartProduct.getPrice());
                product.setValueInList(ProductInOrderAtribute.ImageURL.getAtributeId(),
                        String.valueOf(cartProduct.getImageUrl()));
                product.setValueInList(ProductInOrderAtribute.Summary.getAtributeId(),
                        String.valueOf(cartProduct.getSummary()));
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
            String quantityId = String.valueOf(ProductInOrderAtribute.Quantity.getAtributeId());
            String priceId = String.valueOf(ProductInOrderAtribute.Price.getAtributeId());
            String prodId = String.valueOf(ProductInOrderAtribute.ProductID.getAtributeId());
            String imageId = String.valueOf(ProductInOrderAtribute.ImageURL.getAtributeId());
            String summId = String.valueOf(ProductInOrderAtribute.Summary.getAtributeId());
            List<Entity> list = entityDao.getList(EntityType.ProductInOrder.getTypeId(),
                    String.valueOf(ProductInOrderAtribute.OrderID.getAtributeId()),
                    String.valueOf(order.getId()), "=", quantityId + "," + priceId + "," + prodId +
                            "," + imageId + "," + summId);
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
            String createdDateId = String.valueOf(OrderAtribute.CreatedDate.getAtributeId());
            String totalId = String.valueOf(OrderAtribute.Total.getAtributeId());
            String orderNumberId = String.valueOf(OrderAtribute.OrderNumber.getAtributeId());
            List<Entity> list = entityDao.getByUserAndType(userId, EntityType.Order.getTypeId(),
                    createdDateId + "," + totalId + "," + orderNumberId);
            if (list != null) {
                orderList = new ArrayList<>(list.size());
                for (Entity e : list) {
                    Order o = new Order(e);
                    orderList.add(new Order(e));
                    //System.out.println(o);
                }
            } else
                return null;
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getListForUser for Order");
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return orderList;
    }

    @Override
    public int update(int id, String entityName, int isActive, int userId, List<Value> valuesArr) {
        try {
            entityDao.update(id, entityName, isActive, userId, valuesArr);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " update order #" + id);
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return 0;
    }

    @Override
    public List<Order> getList() {
        List<Order> orderList;
        String createdDateId = String.valueOf(OrderAtribute.CreatedDate.getAtributeId());
        String totalId = String.valueOf(OrderAtribute.Total.getAtributeId());
        String orderNumberId = String.valueOf(OrderAtribute.OrderNumber.getAtributeId());
        String viewStr = createdDateId + "," + totalId + "," + orderNumberId;
        try {
            List<Entity> list = entityDao.getList(EntityType.Order.getTypeId(), "", "", "",
                    viewStr);
            if (list != null) {
                orderList = new ArrayList<>(list.size());
                for (Entity e : list) {
                    Order o = new Order(e);
                    orderList.add(o);
                }
            } else return null;
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getAll for Orders");
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return orderList;
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
    public int rowCounter(int typeId, String atributesId, String values, String operators, String role) {
        return entityDao.rowCounter(EntityType.Order.getTypeId(), atributesId, values, operators, role);
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