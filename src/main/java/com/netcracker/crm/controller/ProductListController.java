package com.netcracker.crm.controller;

import com.netcracker.crm.entity.controllerEntity.controllerService.CartService;
import com.netcracker.crm.entity.controllerEntity.controllerService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ксения on 22.11.2016.
 */

@Controller
public class ProductListController {

    private static final String PRODUCTS = "products";
    private static CartService cart;
    private static ProductService product;

    @Autowired
    public void start(){
        cart = new CartService();
        product = new ProductService();
    }
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(ModelMap model) {
        model.addAttribute("productList", product.getListProduct());
        return PRODUCTS;
    }

    @RequestMapping(value = "/addProduct/{id}", method = RequestMethod.GET)
    public String addProduct(@PathVariable String id, ModelMap model) {
        cart.add(Integer.parseInt(id));
        return "redirect:/"+PRODUCTS;

    }
}
