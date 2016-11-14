package com.netcracker.crm.controller;

import com.netcracker.crm.dao.IEntityDao;
import com.netcracker.crm.dao.IUserDao;
import com.netcracker.crm.dao.impl.EntityDaoImpl;
import com.netcracker.crm.dao.impl.UserDaoImpl;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by egor on 03.11.2016.
 */
public class TestDao {
    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"SpringModule.xml"});

//        List<Value> values =new ArrayList<>();
//        values.add(new Value(0,"16Gb",0,14));
//        values.add(new Value(0,"5.1-inch (diagonal)",0,15));
//        Entity entity=new Entity("Samsung Galaxy S3",true,8,-2,values);
//
        IEntityDao entityDao = (EntityDaoImpl) context.getBean("entityDao");
        System.out.println(entityDao.getById(55));

//        List<User> userList = userDao.getAllByRole(User.ROLE_ADMIN);
//        for (User user:userList) {
//            System.out.println(user.toString());
//
//        }
        // userDao.add(EntityBuilder.buildUser(1452,"4121","13","31","31","31",User.ROLE_USER));

    }
}
