package com.netcracker.crm.services.impl;

import com.netcracker.crm.dao.IEntityDao;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.serviceEntity.Product;
import com.netcracker.crm.services.AbstractService;
import com.netcracker.crm.services.IProductService;
import com.netcracker.crm.services.constants.ServiceConstants;
import com.netcracker.crm.services.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by .. on 20.11.2016.
 */

//еще будет совершенствоваться
@Service("productService")
public class ProductServiceImpl  extends AbstractService<Product> implements IProductService {

    //update и delete одинаковые для всех энтити сервисов ?

    @Autowired
    private IEntityDao entityDao;
    private static Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Override
    public int add(Product product) {
        int id;
        try {
            id = entityDao.add(product);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " add " + product.toString());
        }
        catch(DaoException exc){
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
        }
        catch (DaoException exc){
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return product;
        //return null;
    }


    //пока без атрибутов
    @Override
    public List<Product> getList(String atributesId, String values, String operators) {
        List<Product> productList;
        try{
            List<Entity> list = entityDao.getList(atributesId, values, operators);
            productList = new ArrayList<>(list.size());
            for (Entity e : list) {
                productList.add(new Product(e));
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getAll for Product");
        }
        catch (DaoException exc){
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
        return productList;
    }


    //getAllByType ?


    @Override
    public void update(int id, String entityName, int isActive, int userId, List<Value> valuesArr) {
        try {
            entityDao.update(id, entityName, isActive, userId, valuesArr);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " update product #" + id);
        }
        catch(DaoException exc){
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
    }

    //нужно ли?
    @Override
    public void updateByEntity(Entity entity){
        try {
            entityDao.update(entity.getId(), entity.getEntityName(),
                    entity.getisActive(), entity.getEntityUserId(), entity.getValueList());
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " update product #" + entity.getId());

        } catch(DaoException exc){
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
    }


    @Override
    public void delete(int id) {
        try {
            entityDao.delete(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " delete product #" + id);
        } catch(DaoException exc){
            logger.error(exc.getMessage());
            throw new ServiceException(exc.getMessage(), exc);
        }
    }
}
