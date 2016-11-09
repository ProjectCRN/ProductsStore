package com.netcracker.crm.dao.impl;

import com.netcracker.crm.dao.BaseDataSource;
import com.netcracker.crm.dao.TransactionManager;
import com.netcracker.crm.util.JdbcUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.concurrent.Callable;

/**
 * Created by egor on 03.11.2016.
 */
public class TransactionManagerImpl extends BaseDataSource implements TransactionManager {


    public static final String JDBC_URL = "jdbc:oracle:thin:@//localhost:1521/XE";
    public static final Properties adminProperties = new Properties() {
        {
            setProperty("user", "ns_admin");
            setProperty("password", "qwerty");
        }
    };
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();


    @Override
    public <T> T doTransaction(Callable<T> unitOfWork) throws Exception {
        Connection connection = DriverManager.getConnection(JDBC_URL, adminProperties);
        connection.setAutoCommit(false);
        connectionHolder.set(connection);
        try {
            T result = unitOfWork.call();
            connection.commit();
            return result;
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            JdbcUtils.closeQuietly(connection);
            connectionHolder.remove();
        }
    }

    @Override
    public Connection getConnection() {
        return connectionHolder.get();
    }
}
