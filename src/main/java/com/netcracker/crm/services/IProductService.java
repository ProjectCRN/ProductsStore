package com.netcracker.crm.services;

import com.netcracker.crm.entity.serviceEntity.Product;

import java.util.List;

/**
 * Created by пк on 20.11.2016.
 */
public interface IProductService extends IEntityService<Product> {
    public void updateByProduct(Product product);
    public int rowCounter(int typeId, String atributesId, String values, String operators, String role);
    public List<Product> getByUserAndType(Integer userID, Integer entityTypeID);
    public List<Product> getList(int typeId, String atributesId, String values,
                                 String operators, String atributesIdView,int pageNumber, int pageSize, String role);
    public void restore(int id);

}
