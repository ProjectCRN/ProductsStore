package com.netcracker.crm.services.impl;

import com.netcracker.crm.dao.IEntityDao;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.enums.PhoneAtribute;
import com.netcracker.crm.entity.serviceEntity.Product;
import com.netcracker.crm.services.AbstractService;
import com.netcracker.crm.services.IProductService;
import com.netcracker.crm.services.constants.ServiceConstants;
import com.netcracker.crm.services.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class ProductServiceImpl extends AbstractService<Product> implements IProductService {

    private IEntityDao entityDao;

    private static Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Required
    public void setEntityDao(IEntityDao entityDao) {
        this.entityDao = entityDao;
    }

    @Override
    public int add(Product product) {

        int id;
        try {
            if(entityDao.countEntityName(product.getEntityTypeId(),
                    product.getEntityName())>0)
               return 0;
            id = entityDao.add(product);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " add " + product.toString());
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return id;
    }


    @Override
    public Product getById(int id) {
        Product product;
        try {
            product = new Product(entityDao.getById(id));
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getById " + product.toString());
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return product;
    }

    @Override
    public List<Product> getList(int typeId, String atributesId, String values, String operators, int pageNumber, int pageSize, String role, boolean orderSide) {
        return getList(typeId, atributesId, values, operators, "", pageNumber, pageSize, role, orderSide);
    }

    @Override
    public List<Product> searchByName(int typeId, String searchWord, int pageNumber, int pageSize, String role, boolean orderSide) {
        List<Product> productList;
        String priceId = String.valueOf(getAtributeIdByTypeId(typeId, "Price"));
        String imageId = String.valueOf(getAtributeIdByTypeId(typeId, "ImageURL"));
        String capacityId = String.valueOf(getAtributeIdByTypeId(typeId, "Capacity"));
        String batteryId = String.valueOf(getAtributeIdByTypeId(typeId, "Battery"));
        String viewStr = imageId + "," + priceId + "," + capacityId + "," + batteryId;
        try {
            List<Entity> list =  entityDao.searchByName(typeId,viewStr,searchWord,pageNumber,pageSize,role,orderSide);
            if (list != null) {
                productList = new ArrayList<>(list.size());
                for (Entity e : list) {
                    Product p = new Product(e);
                    productList.add(p);
                }
            } else return null;
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getAll for Product");
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return productList;

    }

    @Override
    public List<Product> getByUserAndType(Integer userID, Integer entityTypeID) {
        List<Product> productList;
        try {
            String imageId = String.valueOf(getAtributeIdByTypeId(entityTypeID, "ImageURL"));
            String priceId = getAtributeIdByTypeId(entityTypeID, "Price");
            List<Entity> list = entityDao.getByUserAndType(userID, entityTypeID, priceId + "," + imageId);
            if (list != null) {
                productList = new ArrayList<>(list.size());
                for (Entity e : list) {
                    Product p = new Product(e);
                    productList.add(p);
                }
            } else return null;
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getByUserAndType for Product");
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return productList;
    }

    @Override
    public List<Product> getList(int typeId, String atributesId, String values,
                                 String operators, String atributesIdView,
                                 int pageNumber, int pageSize, String role, boolean orderSide) {
        List<Product> productList;
        String priceId = String.valueOf(getAtributeIdByTypeId(typeId, "Price"));
        String imageId = String.valueOf(getAtributeIdByTypeId(typeId, "ImageURL"));
        String capacityId = String.valueOf(getAtributeIdByTypeId(typeId, "Capacity"));
        String batteryId = String.valueOf(getAtributeIdByTypeId(typeId, "Battery"));
        String viewStr = imageId + "," + priceId + "," + capacityId + "," + batteryId;
        try {
            List<Entity> list = entityDao.getList(typeId, atributesId, values, operators,
                    viewStr, pageNumber, pageSize, role,orderSide);
            if (list != null) {
                productList = new ArrayList<>(list.size());
                for (Entity e : list) {
                    Product p = new Product(e);
                    productList.add(p);
                }
            } else return null;
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getAll for Product");
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return productList;
    }

    @Override
    public void update(int id, String entityName, int isActive, int userId, List<Value> valuesArr) {
        try {
            entityDao.update(id, entityName, isActive, userId, valuesArr);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " update product #" + id);
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
    }

    @Override
    public void updateByProduct(Product product) {
        try {
            entityDao.updateByEntity(product);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " update product #" + product.getId());

        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
    }

    @Override
    public int rowCounter(int typeId, String atributesId, String values, String operators, String role) {
        return entityDao.rowCounter(typeId, atributesId, values, operators, role);
    }


    @Override
    public void delete(int id) {
        try {
            entityDao.delete(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " delete product #" + id);
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
    }

    @Override
    public void restore(int id) {
        try {
            entityDao.restore(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " restore product #" + id);
        } catch (DaoException exc) {
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
    }
}