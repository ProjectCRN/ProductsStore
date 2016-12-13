package com.netcracker.crm.services.impl;

import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.controllerEntity.form.OrderForm;
import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.serviceEntity.Product;
import com.netcracker.crm.services.IProductService;
import com.netcracker.crm.services.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by on 12.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:test-SpringModule.xml"})
public class DataTest {

    @Autowired
    MockHttpSession session;

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @Autowired
    @Qualifier("productService")
    private IProductService productService;

    @Test
    public void testAdminExists() {
        int id = userService.getIdByLogin("Admin");
        assertTrue(-2 == id);
    }

    @Test
    public void testAnonExists() {
        int id = userService.getIdByLogin("Ananymous");
        assertTrue(-1 == id);
    }

    @Test
    public void testOrderFieldsSetting() {
        User user = new User(1, "Vasya", "123",
                "Vasya", "80171357911", "Minsk, Ulyanovskaya, 15",
                User.ROLE_USER, "vasya@gmail.com");
        OrderForm orderForm1 = new OrderForm();
        orderForm1.setFieldsFromUser(user);
        OrderForm orderForm2 = new OrderForm("Vasya", "80171357911", "Minsk, Ulyanovskaya, 15");
        assertTrue(orderForm1.equals(orderForm2));
    }

    @Test
    public void testInitialDataTelephone() {
        List<Product> productList = productService.getList(EntityType.Telephone.getTypeId(),
                "","","","",1,3,"A",true);
        assertTrue(productList.size()==3);
    }
    
    @Test
    public void testInitialDataTablet() {
        List<Product> productList = productService.getList(EntityType.Tablet.getTypeId(),
                "","","","",1,2,"A",true);
        assertTrue(productList.size()==2);
    }
}