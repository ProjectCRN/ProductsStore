package com.netcracker.crm.controller;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.controllerEntity.SignupForm;
import com.netcracker.crm.entity.controllerEntity.SignupValidator;
import com.netcracker.crm.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.validation.BindingResult;

@Controller

@RequestMapping("/createUser")
public class UserLoginController{

    private static final String REGISTER = "register";
    private static final String REGISTER_SUCCESS = "register-success";
    private SignupValidator signupValidator;
    private IUserService userService;
    private User user;

    @Required
    public void setUser(User user) {
        this.user = user;
    }

    @Required
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Required
    public void setSignupValidator(SignupValidator signupValidator) {
        this.signupValidator = signupValidator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String signup(ModelMap model) {
        SignupForm signupForm = new SignupForm();
        model.put("signupForm", signupForm);
        return REGISTER;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSignup(SignupForm signupForm, BindingResult result, ModelMap model) {
        signupValidator.validate(signupForm, result);
        if (result.hasErrors()) {
            return REGISTER;
        }
        signupForm.setRoleId(User.ROLE_USER);
        signupForm.setId(5);
        userService.add(signupForm);
        user.clone(signupForm);
        model.addAttribute("user", user);
        return REGISTER_SUCCESS;
    }
}