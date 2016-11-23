package com.netcracker.crm.controller;
import com.netcracker.crm.entity.controllerEntity.SignupForm;
import com.netcracker.crm.entity.controllerEntity.SignupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.validation.BindingResult;

@Controller

@RequestMapping("/createUser")
public class UserLoginController{

    @Autowired
    private SignupValidator signupValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String signup(ModelMap model) {
        SignupForm signupForm = new SignupForm();
        model.put("signupForm", signupForm);
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSignup(SignupForm signupForm, BindingResult result) {
        signupValidator.validate(signupForm, result);
        if (result.hasErrors()) {
            return "signup";
        }
        return "redirect:/";
    }
}