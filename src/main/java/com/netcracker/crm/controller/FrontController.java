package com.netcracker.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class FrontController {

    private static final String VIEW_INDEX = "mainJSP";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("message", "Welcome");
        return VIEW_INDEX;

    }
}
