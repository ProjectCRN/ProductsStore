package com.netcracker.crm.entity.controllerEntity;

import com.netcracker.crm.entity.User;

/**
 * Created by Ксения on 22.11.2016.
 */
public class UserRegisterForm extends User {
    private String confirmPassword;

    public UserRegisterForm() {
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
