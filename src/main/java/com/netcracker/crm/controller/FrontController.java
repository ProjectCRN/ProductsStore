package com.netcracker.crm.controller;

import com.netcracker.crm.entity.controllerEntity.Cart;
import com.netcracker.crm.entity.controllerEntity.Order;
import com.netcracker.crm.entity.controllerEntity.ProductList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import java.util.Random;


@Controller
public class FrontController {

    private static final String VIEW_INDEX = "mainJSP";
    private static final String PRODUCTS = "products";
    private static final String CART = "cart";
    private static final String ITEM = "item";
    private static final String ORDER = "order";
    private static final String CHECK = "checkOrder";
    private static ProductList productList = new ProductList();
    private static Cart cart = new Cart();

    private static Random rand = new Random();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("message", "Very very interesting text");
        return VIEW_INDEX;

    }



    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String item(@PathVariable String id, ModelMap model) {
        model.addAttribute("item",productList.find(Integer.parseInt(id)));
        return ITEM;
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public String createOrder(ModelMap model) {
        model.addAttribute("order", new Order());
        return ORDER;
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute("order") @Valid Order order, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("order", order);
            model.addAttribute("msg", "please, try again");
            return ORDER;
        }
        order.setId(rand.nextInt());
        order.setCartItemList(cart.getListCartItem());
        order.setTotal(cart.getTotal());
        model.addAttribute("order",order);
        return CHECK;
    }
}