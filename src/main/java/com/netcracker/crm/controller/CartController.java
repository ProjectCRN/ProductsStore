package com.netcracker.crm.controller;

import com.netcracker.crm.services.ICartService;
import org.springframework.beans.factory.annotation.Required;
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
    private ICartService cartService;

    @Required
    public void setCartService(ICartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(ModelMap model) {
        model.addAttribute("cartList", cartService.getCart().getCartItems());
        model.addAttribute("total", cartService.countTotal());
        model.addAttribute("prev","cart");
        return CART;
    }

    @RequestMapping(value = "/addProduct/{id}", method = RequestMethod.GET)
    public void addProduct(@PathVariable String id, ModelMap model) {
        cartService.addProduct(Integer.parseInt(id));
    }

    @RequestMapping(value = "/addCartProduct/{id}", method = RequestMethod.GET)
    public String addCartProduct(@PathVariable String id, ModelMap model) {
        cartService.addProduct(Integer.parseInt(id));
        return "redirect:/" + CART;
    }

    @RequestMapping(value = "/deleteCartProduct/{id}", method = RequestMethod.GET)
    public String deleteCartProduct(@PathVariable String id, ModelMap model) {
        cartService.delete(Integer.parseInt(id));
        return "redirect:/" + CART;
    }


}
