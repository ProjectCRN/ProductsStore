package com.netcracker.crm.controller;

import com.netcracker.crm.commands.CommandDispatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class FrontController {

    private static final String VIEW_INDEX = "mainJSP";
    private static List<String> requestList = new ArrayList<String>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("message", "Welcome");
        return VIEW_INDEX;

    }

    @RequestMapping(value = "/{request}", method = RequestMethod.GET)
    public ModelAndView requestOneParam(@PathVariable String request, ModelMap model) {
        requestList.clear();
        requestList.add(request);
        return CommandDispatcher.getRequest(requestList);

    }

    @RequestMapping(value = "/{request}/{id}", method = RequestMethod.GET)
    public ModelAndView requestTwoParam(@PathVariable String request, @PathVariable String id, ModelMap model) {
        requestList.clear();
        requestList.add(request);
        requestList.add(id);
        return CommandDispatcher.getRequest(requestList);

    }
}
