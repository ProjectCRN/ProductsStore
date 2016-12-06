package com.netcracker.crm.entity.controllerEntity.form;

import com.netcracker.crm.entity.User;

/**
 * Created by Ксения on 21.11.2016.
 */
public class SignupForm extends User {

    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}