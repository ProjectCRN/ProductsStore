package com.netcracker.crm.controller;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.controllerEntity.LoginForm;
import com.netcracker.crm.entity.controllerEntity.LoginValidator;
import com.netcracker.crm.entity.controllerEntity.SignupForm;
import com.netcracker.crm.entity.controllerEntity.SignupValidator;
import com.netcracker.crm.services.ICartService;
import com.netcracker.crm.services.IUserService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.validation.BindingResult;

@Controller
public class UserLoginController{

    private static final String REGISTER = "register";
    private static final String LOGIN = "login";
    private static final String REGISTER_SUCCESS = "register-success";
    private SignupValidator signupValidator;
    private LoginValidator loginValidator;
    private IUserService userService;
    private ICartService cartService;
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

    @Required
    public void setLoginValidator(LoginValidator loginValidator) {
        this.loginValidator = loginValidator;
    }

    @Required
    public void setCartService(ICartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value="/createUser", method = RequestMethod.GET)
    public String signup(ModelMap model) {
        SignupForm signupForm = new SignupForm();
        model.put("signupForm", signupForm);
        return REGISTER;
    }

    @RequestMapping(value="/createUser", method = RequestMethod.POST)
    public String processSignup(SignupForm signupForm, BindingResult result, ModelMap model) {
        signupValidator.validate(signupForm, result);
        if (result.hasErrors()) {
            return REGISTER;
        }
        signupForm.setRoleId(User.ROLE_USER);
        if(signupForm.getUserName().equals(""))
            signupForm.setUserName(signupForm.getLogin());
        userService.add(signupForm);
        user.clone(signupForm);
        int id=userService.getIdByLogin(signupForm.getLogin());
        cartService.getCart().setId(id);
        model.addAttribute("hello", "Hello, "+user.getUserName()+"!");
        model.addAttribute("msg", "Nice to meet you in our little shop ^_^");
        return REGISTER_SUCCESS;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        LoginForm loginForm = new LoginForm();
        model.put("loginForm", loginForm);
        return LOGIN;
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String processLogin(LoginForm loginForm, BindingResult result, ModelMap model) {
        loginValidator.validate(loginForm, result);
        if (result.hasErrors()) {
            return LOGIN;
        }
        int id=userService.getIdByLogin(loginForm.getLogin());
        User buf = userService.getById(id);
        user.clone(buf);
        cartService.getCart().setId(id);
        model.addAttribute("hello", "Hello, "+user.getUserName()+"!");
        model.addAttribute("msg", "Nice to meet you in our little shop ^_^");
        return REGISTER_SUCCESS;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        model.addAttribute("hello", "Goodbye, "+user.getUserName()+"!");
        user.logout();
        cartService.getCart().setId(user.getId());
        model.addAttribute("msg", "See you later in our little shop ^_^");
        return REGISTER_SUCCESS;
    }
}