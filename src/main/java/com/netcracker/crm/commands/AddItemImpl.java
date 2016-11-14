package com.netcracker.crm.commands;

import com.netcracker.crm.entity.controllerEntity.Container;
import org.springframework.web.servlet.ModelAndView;

public class AddItemImpl implements ICommand {
    @Override
    public ModelAndView execute() {
        return null;
    }

    @Override
    public ModelAndView execute(int id) {
        Container.getCart().add(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/products");
        return modelAndView;
    }
}
