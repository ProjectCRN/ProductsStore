package com.netcracker.crm.services;

import com.netcracker.crm.entity.serviceEntity.Product;

import java.util.List;

/**
 * Created by пк on 20.11.2016.
 */
public interface IProductService extends IEntityService<Product> {
    void updateByProduct(Product product);
    int rowCounter(int typeId, String atributesId, String values, String operators, String role);
    List<Product> getByUserAndType(Integer userID, Integer entityTypeID);
    List<Product> getList(int typeId, String atributesId, String values,
                          String operators, String atributesIdView,
                          int pageNumber, int pageSize, String role);
    List<Product> getList(int typeId, String atributesId, String values,
                          String operators, int pageNumber, int pageSize, String role);
    void restore(int id);
}
