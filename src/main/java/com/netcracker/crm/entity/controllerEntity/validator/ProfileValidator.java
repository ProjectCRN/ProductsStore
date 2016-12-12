package com.netcracker.crm.entity.controllerEntity.validator;

import com.netcracker.crm.entity.controllerEntity.form.ProfileForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Ксения on 12.12.2016.
 */
public class ProfileValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return ProfileForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ProfileForm profileForm = (ProfileForm) target;


        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "Username must not be empty.");
        String username = profileForm.getUserName();

        if (!(username.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$"))) {
            errors.rejectValue("userName", "userName.userNameDontMatch", "Username don't match.");
        }



        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactPhone", "contactPhone.empty", "ContactPhone must not be empty.");

        String contactPhone = profileForm.getContactPhone();

        if (!(contactPhone.equals("") || contactPhone.matches("^((8|\\+375)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$"))) {
            errors.rejectValue("contactPhone", "contactPhone.contactPhoneDontMatch", "Phone don't match");
        }

        /*String contactAddress = signupForm.getContactAddress();
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactAddress", "contactAddress.empty", "ContactAddress must not be empty.");
        if (!contactAddress.matches("^[a-zA-Z0-9 .,\'\"-]+$")) {
            errors.rejectValue("contactAddress", "contactAddress.contactAddressDontMatch", "Incorrect symbols.");
        }*/

    }
}
