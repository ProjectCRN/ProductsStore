package com.netcracker.crm.entity.controllerEntity.validator;

import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.controllerEntity.form.SignupForm;
import com.netcracker.crm.entity.controllerEntity.form.LoginForm;
import com.netcracker.crm.services.IUserService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Ксения on 05.12.2016.
 */
public class LoginValidator implements Validator {
    private IUserService userService;

    @Required
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
            return SignupForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        LoginForm loginForm = (LoginForm)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty", "Login must not be empty.");
        String login = loginForm.getLogin();

        if (!login.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$")) {
            errors.rejectValue("login", "login.loginDontMatch", "Login don't match.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");

        String password = loginForm.getPassword();

        if(userService.isLoginFree(login))
        {
            errors.rejectValue("login", "login.loginFree", "No such user.");
        }
        else {
            int id = userService.getIdByLogin(login);
            User user = userService.getById(id);
            if(!(userService.hashing(password)).equals(user.getPassword()))
                errors.rejectValue("password", "password.loginDontMatch", "Wrong password.");
        }


    }
}
