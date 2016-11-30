package com.netcracker.crm.commands;

import com.netcracker.crm.entity.controllerEntity.Container;
import org.springframework.web.servlet.ModelAndView;


public class GetItemListImpl implements ICommand {
    @Override
    public ModelAndView execute() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList", Container.getProductList().getListProduct());
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @Override
    public ModelAndView execute(int id) {
        return null;
    }

}
