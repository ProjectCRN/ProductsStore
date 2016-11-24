package com.netcracker.crm.entity.controllerEntity;


//import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class UserRegisterValidation implements Validator{
    public boolean supports(Class<?> clazz) {
        return UserRegisterForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        UserRegisterForm userRegisterForm = (UserRegisterForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty", "Login must not be empty.");
       /* String login = userRegisterForm.getLogin();
        if ((login.length()) > 20 || (login.length())<6) {
            errors.rejectValue("login", "login.tooLong", "Login must be between 6 and 20 characters.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "Username must not be empty.");
        String username = userRegisterForm.getUserName();
        if ((username.length()) > 30) {
            errors.rejectValue("userName", "userName.tooLong", "Username must not more than 30 characters.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
        if (!(userRegisterForm.getPassword()).equals(userRegisterForm
                .getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Passwords don't match.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactPhone", "contactPhone.empty", "ContactPhone must not be empty.");
        String contactPhone = userRegisterForm.getContactPhone();
        Pattern p = Pattern.compile("^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$");
        Matcher m = p.matcher(contactPhone);
        if (!m.matches()) {
            errors.rejectValue("contactPhone", "contactPhone.contactPhoneDontMatch", "Possible patterns +375XX XXX XX XX and 80XX XXX XX XX.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactAddress", "contactAddress.empty", "ContactAddress must not be empty.");*/

    }
}
