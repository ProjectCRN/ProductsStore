package com.netcracker.crm.controller;

import com.netcracker.crm.entity.serviceEntity.Product;
import com.netcracker.crm.services.IProductService;
import com.netcracker.crm.services.parser.CatalogParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
//              IEntityDao entityDao = (EntityDaoImpl) context.getBean("entityDao");
//        System.out.println(entityDao.getById(47));
//            for(Entity item : entityDao.getList(8,"","","")){
//            System.out.println(item.getId());
//          }

// -----USER SERVICES-----
//      IUserService userService = (UserServiceImpl) context.getBean("userService");
//       List<User> userList = userService.getAll();
//       UserListWorker.sortById(userList);
//      userList = UserListWorker.getFromTo(userList, 0, 52313);
//        for (User user : userList             ) {
//            System.out.println(user.toString());
//        }
//        userService.isLoginFree("admin");
//        userService.isLoginFree("adm21in");
//
//        userService.isEmailFree("gav@panin.ru");

        IProductService productService = (IProductService) context.getBean("productService");
//
//        productService.getByUserAndType(-2, null);
//       Product product = productService.getById(53);
//        List <Product> productList = productService.getByUserAndType(-2,8);
//        for (Product op : productList) {
//            System.out.println(op.toString());
//        }
//        int a = product.getOrderId();
        CatalogParser catalogParser = (CatalogParser) context.getBean("catalogParser");
        catalogParser.importCatalog("default");
        System.out.println("check db");
        catalogParser.exportCatalog("default");

//        productService.delete(43);
//        productService.update(40, "iphone6s", 1, -2, null);
//        List<Value> values = new ArrayList<>();
//        values.add(new Value(41, "16Gb", 40, 14));
//        productService.update(40, "iphone6s", 1, -2, values);
        //Cart example
//        ICartService cartService= (CartServiceImpl) context.getBean("cartService");
//        Cart cart=new Cart(-1);
//        cartService.add(cart);
//        cartService.addProduct(49);
//        cartService.addProduct(50);
//        cartService.addProduct(51);
//        cartService.changeQuantity(49,2);
//        cartService.delete(51);
//        cartService.countTotal();
//        System.out.println(cartService.getCart().toString());


    }
}
