package com.netcracker.crm.controller;

import com.netcracker.crm.entity.User;

import com.netcracker.crm.entity.controllerEntity.CartQuantity;
import com.netcracker.crm.entity.controllerEntity.form.OrderForm;
import com.netcracker.crm.entity.controllerEntity.validator.OrderValidator;
import com.netcracker.crm.entity.serviceEntity.Order;
import com.netcracker.crm.services.ICartService;
import com.netcracker.crm.services.IOrderService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class OrderController {

    private static final String ORDER = "order";
    private static final String CHECK = "checkOrder";
    private static final String ALL_ORDERS = "allOrders";
    private static final String NO_ROOTS = "noRoots";
    private static final String CART = "cart";
    private ICartService cartService;
    private IOrderService orderService;
    private OrderValidator orderValidator;
    private User user;

    @Required
    public void setUser(User user) {
        this.user = user;
    }

    @Required
    public void setCartService(ICartService cartService) {
        this.cartService = cartService;
    }

    @Required
    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Required
    public void setOrderValidator(OrderValidator orderValidator) {
        this.orderValidator = orderValidator;
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public String createOrder(ModelMap model) {

        OrderForm order = new OrderForm();
        if (user.getRoleId().equals(User.ROLE_ANON)) {
            model.addAttribute("order", order);
        } else {
            order.setFieldsFromUser(user);
            model.addAttribute("order", order);
        }
        return ORDER;
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public String saveOrder(OrderForm orderForm, BindingResult result, ModelMap model) {
        orderValidator.validate(orderForm, result);
        if (result.hasErrors()) {
            return ORDER;
        }

        Order order = orderService.makeOrderByCart(cartService.getCart());
        order.setFieldsFromForm(orderForm);
        orderService.add(order);
        model.addAttribute("order", order);
        cartService.clearCart();
        return CHECK;
    }

    @RequestMapping(value = "/getAllOrders", method = RequestMethod.GET)
    public String getAllOrders(ModelMap model) {
        if (user.isAnon())
            return NO_ROOTS;
        List<Order> orderList = orderService.getListForUser(user.getId());
        model.addAttribute("orderList", orderList);
        model.addAttribute("role", "U");
        return ALL_ORDERS;
    }

    @RequestMapping(value = "/userOrders", method = RequestMethod.GET)
    public String getUserOrders(ModelMap model) {
        if (!user.isAdmin())
            return NO_ROOTS;
        List<Order> orderList = orderService.getList();
        model.addAttribute("orderList", orderList);
        model.addAttribute("role", user.getRoleId());
        return ALL_ORDERS;
    }

    @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.GET)
    public String deleteOrder(@PathVariable String id, ModelMap model) {
        if (!user.isAdmin())
            return NO_ROOTS;
        orderService.delete(Integer.parseInt(id));
        return "redirect:/userOrders";
    }

    @RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
    public String getOrder(@PathVariable String id, ModelMap model) {
        if (user.isAnon())
            return NO_ROOTS;
        Order order = orderService.getById(Integer.parseInt(id));
        if (user.getId() != order.getEntityUserId() && !user.isAdmin())
            return NO_ROOTS;
        model.addAttribute("order", order);
        return CHECK;
    }

    @RequestMapping(value = "/getCart/{id}", method = RequestMethod.GET)
    public String getCartFromOrder(@PathVariable String id, ModelMap model) {
        if (user.isAnon())
            return NO_ROOTS;
        Order order = orderService.getById(Integer.parseInt(id));
        if (user.getId() != order.getEntityUserId())
            return NO_ROOTS;
        model.addAttribute("cartList", order.getCart().getCartItems());
        model.addAttribute("total", order.getTotal());
        model.addAttribute("cartQuantity", new CartQuantity());
        model.addAttribute("prev", "2");
        return CART;
    }
}
