package com.netcracker.crm.commands;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;


public class CommandDispatcher {

    public static ModelAndView getRequest(List<String> request) {
        ModelAndView mv = new ModelAndView();
        if (request.size() == 1) {
            if (request.get(0).equals("products")) {
                mv = new GetItemListImpl().execute();
                return mv;
            }

            if (request.get(0).equals("cart")) {
                mv = new GetCartImpl().execute();
                return mv;
            }
        }
        if (request.size() == 2) {
            if (request.get(0).equals("addProduct")) {
                mv = new AddItemImpl().execute(Integer.parseInt(request.get(1)));
                return mv;
            }
        }
        return mv;
    }
}
