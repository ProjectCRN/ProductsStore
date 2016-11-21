package com.netcracker.crm.controller;

import com.netcracker.crm.dao.IDao;
import com.netcracker.crm.dao.IEntityDao;
import com.netcracker.crm.dao.IUserDao;
import com.netcracker.crm.dao.impl.EntityDaoImpl;
import com.netcracker.crm.dao.impl.UserDaoImpl;
import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Entity;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.services.IProductService;
import com.netcracker.crm.services.IUserService;
import com.netcracker.crm.services.impl.ProductServiceImpl;
import com.netcracker.crm.services.impl.UserServiceImpl;
import com.netcracker.crm.services.listworker.UserListWorker;
import javafx.util.Pair;
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
  //      IEntityDao entityDao = (EntityDaoImpl) context.getBean("entityDao");
//        System.out.println(entityDao.getById(55));
    //    for(Entity item : entityDao.getList("14","32Gb","=")){
        //    System.out.println(item.getId());
      //  }


//        List<User> userList = userDao.getAllByRole(User.ROLE_ADMIN);
//        for (User user:userList) {
//            System.out.println(user.toString());
//
//        }
        // userDao.add(EntityBuilder.buildUser(1452,"4121","13","31","31","31",User.ROLE_USER));

        IUserService userService = (UserServiceImpl) context.getBean("userService");
        List<User> userList = userService.getAll();
        UserListWorker.sortById(userList);
        userList = UserListWorker.getFromTo(userList,0,52313);

 //       IProductService productService = (ProductServiceImpl) context.getBean("productService");

     }
}
