package com.netcracker.crm.services.impl;

import com.netcracker.crm.entity.AbstractEntity;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.serviceEntity.Product;
import com.netcracker.crm.services.AbstractService;
import com.netcracker.crm.services.IEntityService;
import com.netcracker.crm.services.IProductService;

import java.util.List;

/**
 * Created by οκ on 20.11.2016.
 */
public class ProductServiceImpl  extends AbstractService<Product> implements IProductService {
    @Override
    public void update(int id, String entityName, int isActive, int userId, List<Value> valuesArr) {

    }

    @Override
    public List<Product> getList(String atributesId, String values, String operators) {
        return null;
    }


    @Override
    public int add(Product product) {
        return 0;
    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
