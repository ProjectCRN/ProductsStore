package com.netcracker.crm.entity.controllerEntity.form;

import com.netcracker.crm.entity.User;

/**
 * Created by Ксения on 12.12.2016.
 */
public class ProfileForm {
    String userName;
    String contactPhone;
    String contactAddress;

    public void setFieldsFromUser(User user){
        this.userName = user.getUserName();
        this.contactPhone = user.getContactPhone();
        this.contactAddress = user.getContactAddress();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }
}
