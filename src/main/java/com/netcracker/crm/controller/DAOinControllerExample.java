package com.netcracker.crm.controller;

import com.netcracker.crm.dao.IDao;
import com.netcracker.crm.dao.TransactionManager;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.dao.impl.TransactionManagerImpl;
import com.netcracker.crm.dao.impl.UserDaoImpl;
import com.netcracker.crm.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.concurrent.Callable;

/**
 * Created by egor on 03.11.2016.
 */
public class DAOinControllerExample {


    public void doGet() throws Exception {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"appContext-dao.xml"});

        TransactionManager txManager = (TransactionManagerImpl) context.getBean("txManager");
        final IDao<User> userDao = (UserDaoImpl) context.getBean("userDao");


        final int id = -1;
        User user = txManager.doTransaction(new Callable<User>() {

            @Override
            public User call() throws DaoException{
               return userDao.getById(id);
            }
        });
        System.out.println(user.toString());
    }



}
