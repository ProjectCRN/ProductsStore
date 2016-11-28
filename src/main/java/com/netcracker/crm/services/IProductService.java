package com.netcracker.crm.services;

import com.netcracker.crm.entity.serviceEntity.Product;

import java.util.List;

/**
 * Created by пк on 20.11.2016.
 */
public interface IProductService extends IEntityService<Product> {
    public void updateByProduct(Product entity);
    public List<Product> getByUserAndType(Integer userID, Integer entityTypeID);
}
