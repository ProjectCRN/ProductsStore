package com.netcracker.crm.dao;

import javax.sql.DataSource;
import java.util.concurrent.Callable;

/**
 * Created by egor on 03.11.2016.
 */
public interface TransactionManager{
    public <T> T doTransaction(Callable<T> unitOfWork) throws Exception;
}
