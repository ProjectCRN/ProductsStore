package com.netcracker.crm.entity.controllerEntity.validator;

import com.netcracker.crm.entity.controllerEntity.form.OrderForm;
import com.netcracker.crm.entity.serviceEntity.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Ксения on 05.12.2016.
 */
public class OrderValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return OrderForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        OrderForm order = (OrderForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactName", "contactName.empty", "ContactName must not be empty.");
        String contactName = order.getContactName();

        if (!(contactName.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$"))) {
            errors.rejectValue("contactName", "contactName.contactNameDontMatch", "ContactName don't match.");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactPhone", "contactPhone.empty", "ContactPhone must not be empty.");

        String contactPhone = order.getContactPhone();

        if (!(contactPhone.matches("^((8|\\+375)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$"))) {
            errors.rejectValue("contactPhone", "contactPhone.contactPhoneDontMatch", "Phone don't match");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactAddress", "contactAddress.empty", "ContactAddress must not be empty.");
        /*String contactAddress = signupForm.getContactAddress();
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactAddress", "contactAddress.empty", "ContactAddress must not be empty.");
        if (!contactAddress.matches("^[a-zA-Z0-9 .,\'\"-]+$")) {
            errors.rejectValue("contactAddress", "contactAddress.contactAddressDontMatch", "Incorrect symbols.");
        }*/

    }
}
