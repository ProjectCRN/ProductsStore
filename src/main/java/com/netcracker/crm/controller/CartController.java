package com.netcracker.crm.controller;

import com.netcracker.crm.entity.controllerEntity.controllerService.CartService;
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
public class CartController {

    private static final String CART = "cart";

    private static CartService cart = new CartService();

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(ModelMap model) {
        model.addAttribute("cartList", cart.getListCartItem());
        model.addAttribute("total", cart.getTotal());
        return CART;
    }

    @RequestMapping(value = "/addCartProduct/{id}", method = RequestMethod.GET)
    public String addCartProduct(@PathVariable String id, ModelMap model) {
        cart.add(Integer.parseInt(id));
        return "redirect:/"+CART;
    }

    @RequestMapping(value = "/deleteCartProduct/{id}", method = RequestMethod.GET)
    public String deleteCartProduct(@PathVariable String id, ModelMap model) {
        cart.delete(Integer.parseInt(id));
        return "redirect:/"+CART;
    }


}
