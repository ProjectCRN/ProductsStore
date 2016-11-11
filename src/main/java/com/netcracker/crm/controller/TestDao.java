package com.netcracker.crm.controller;

import com.netcracker.crm.dao.IUserDao;
import com.netcracker.crm.dao.impl.UserDaoImpl;
import com.netcracker.crm.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by egor on 03.11.2016.
 */
public class TestDao {
    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"SpringModule.xml"});

        IUserDao userDao = (UserDaoImpl) context.getBean("userDao");
        System.out.println(userDao.getById(-1));

        List<User> userList = userDao.getAllByRole(User.ROLE_ADMIN);
        for (User user:userList
                ) {
            System.out.println(user.toString());

        }
        // userDao.add(EntityBuilder.buildUser(1452,"4121","13","31","31","31",User.ROLE_USER));

    }
}
