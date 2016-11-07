package com.netcracker.crm.controller;

import com.netcracker.crm.dao.IDao;
import com.netcracker.crm.dao.TransactionManager;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.dao.impl.TransactionManagerImpl;
import com.netcracker.crm.dao.impl.UserDaoImplCalls;
import com.netcracker.crm.entity.EntityBuilder;
import com.netcracker.crm.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * Created by egor on 03.11.2016.
 */
public class DAOinControllerExample {


    public void doGet() throws Exception {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"appContext-dao.xml"});

        TransactionManager txManager = (TransactionManagerImpl) context.getBean("txManager");
        final IDao<User> userDao = (UserDaoImplCalls) context.getBean("userDao");


        final int id = -1;


        // GET BY ID
        User user = txManager.doTransaction(new Callable<User>() {

            @Override
            public User call() throws DaoException{
               return userDao.getById(id);
            }
        });
        //---------------

        System.out.println(user.toString());

        System.out.println("--------------------");

        Integer newId = txManager.doTransaction(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return userDao.add(EntityBuilder.buildUser(0,"User"+userDao.getMaxId(),"password","username","address","phone",User.ROLE_USER));
             }
        });


        List<User> all = new ArrayList<>();
        all = txManager.doTransaction(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return userDao.getAll();
            }
        });

        Iterator iterator = all.iterator();
        while (iterator.hasNext()){
            user = (User)iterator.next();
            System.out.println(user.toString());
        }


    }



}
