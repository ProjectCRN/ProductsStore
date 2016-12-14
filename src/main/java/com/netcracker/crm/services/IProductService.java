package com.netcracker.crm.services;

import com.netcracker.crm.entity.serviceEntity.Product;

import java.util.List;


public interface IProductService extends IEntityService<Product> {
    int updateByProduct(Product product);

    int rowCounter(int typeId, String atributesId, String values, String operators, String role);

    List<Product> getByUserAndType(Integer userID, Integer entityTypeID);

    List<Product> getList(int typeId, String atributesId, String values,
                          String operators, String atributesIdView,
                          int pageNumber, int pageSize, String role, boolean orderSide);

    List<Product> getList(int typeId, String atributesId, String values,
                          String operators, int pageNumber, int pageSize, String role, boolean orderSide);

    List<Product> searchByName(int typeId, String searchWord, int pageNumber, int pageSize, String role, boolean orderSide);

    void restore(int id);
}
