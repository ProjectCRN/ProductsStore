package com.netcracker.crm.commands;

import com.netcracker.crm.entity.controllerEntity.Container;
import org.springframework.web.servlet.ModelAndView;


public class GetCartImpl implements ICommand {
    @Override
    public ModelAndView execute() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cartList", Container.getCart().getListCartItem());
        modelAndView.addObject("total", Container.getCart().getTotal());
        modelAndView.setViewName("cart");
        return modelAndView;
    }

    @Override
    public ModelAndView execute(int id) {
        return null;
    }
}
