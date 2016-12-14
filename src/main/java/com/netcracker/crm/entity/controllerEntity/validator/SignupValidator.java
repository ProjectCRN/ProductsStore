package com.netcracker.crm.entity.controllerEntity.validator;

/**
 * Created by Ксения on 21.11.2016.
 */
import com.netcracker.crm.entity.controllerEntity.form.SignupForm;
import com.netcracker.crm.services.IUserService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SignupValidator implements Validator {

    IUserService userService;

    @Required
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public boolean supports(Class<?> clazz) {
        return SignupForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        SignupForm signupForm = (SignupForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty", "Login must not be empty.");
        String login = signupForm.getLogin();

        if (!login.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$")) {
            errors.rejectValue("login", "login.loginDontMatch", "Login don't match.");
        }
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "Username must not be empty.");
        String username = signupForm.getUserName();

        if (!(username.equals("") || username.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$"))) {
            errors.rejectValue("userName", "userName.userNameDontMatch", "Username don't match.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
        if (!(signupForm.getPassword()).equals(signupForm
                .getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Passwords don't match.");
        }

        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactPhone", "contactPhone.empty", "ContactPhone must not be empty.");

        String contactPhone = signupForm.getContactPhone();

        if (!(contactPhone.equals("") || contactPhone.matches("^((8|\\+375)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$"))) {
            errors.rejectValue("contactPhone", "contactPhone.contactPhoneDontMatch", "Phone don't match");
        }

        /*String contactAddress = signupForm.getContactAddress();
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactAddress", "contactAddress.empty", "ContactAddress must not be empty.");
        if (!contactAddress.matches("^[a-zA-Z0-9 .,\'\"-]+$")) {
            errors.rejectValue("contactAddress", "contactAddress.contactAddressDontMatch", "Incorrect symbols.");
        }*/

        String email = signupForm.getEmail();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "Email must not be empty.");
        if (!email.matches("\\S+@[a-z]+.[a-z]+")) {
            errors.rejectValue("email", "email.emailDontMatch", "Not valid email.");
        }

        if(!userService.isLoginFree(login))
        {
            errors.rejectValue("login", "login.loginDontFree", "Login don't free.");
        }

        if(!userService.isEmailFree(email))
        {
            errors.rejectValue("email", "email.emailDontFree", "Email don't free.");
        }
    }
}