package com.netcracker.crm.entity.controllerEntity;

/**
 * Created by Ксения on 21.11.2016.
 */
import com.netcracker.crm.entity.controllerEntity.SignupForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class SignupValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return SignupForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        SignupForm signupForm = (SignupForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty", "Login must not be empty.");
        String login = signupForm.getLogin();
        if ((login.length()) > 20 || (login.length()) < 6) {
            errors.rejectValue("login", "login.tooLong", "Login must be between 6 and 20 characters.");
        }

        if (!login.matches("^[a-zA-Z0-9]+$")) {
            errors.rejectValue("login", "login.loginDontMatch", "Login must contain only letters and numbers.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "Username must not be empty.");
        String username = signupForm.getUserName();

        if ((username.length()) > 30) {
            errors.rejectValue("userName", "userName.tooLong", "Username must not more than 30 characters.");
        }

        if (!username.matches("^[a-zA-Z ]+$")) {
            errors.rejectValue("userName", "userName.userNameDontMatch", "Username must contain only letters and spaces.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
        if (!(signupForm.getPassword()).equals(signupForm
                .getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Passwords don't match.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactPhone", "contactPhone.empty", "ContactPhone must not be empty.");

        String contactPhone = signupForm.getContactPhone();

        if (!contactPhone.matches("^[0-9 +)(-]+$")) {
            errors.rejectValue("contactPhone", "contactPhone.contactPhoneDontMatch", "Phone must contain only numbers fnd symbols");
        }

        String contactAddress = signupForm.getContactAddress();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactAddress", "contactAddress.empty", "ContactAddress must not be empty.");
        if (!contactAddress.matches("^[a-zA-Z0-9 .,\'\"-]+$")) {
            errors.rejectValue("contactAddress", "contactAddress.contactAddressDontMatch", "Incorrect symbols.");
        }
    }
}