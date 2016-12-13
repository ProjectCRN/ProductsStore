package com.netcracker.crm.controller;

import com.netcracker.crm.entity.User;

import com.netcracker.crm.entity.controllerEntity.NameSearch;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class FrontController {

    private static final String VIEW_INDEX = "mainJSP";
    private static final String PAGE_NOT_FOUND = "page404";

    private User user;

    @Required
    public void setUser(User user) {
        this.user = user;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("userRole",user.getRoleId());
        model.addAttribute("message", "Our dream team ^_^");
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("user",user);


        return VIEW_INDEX;
    }

}