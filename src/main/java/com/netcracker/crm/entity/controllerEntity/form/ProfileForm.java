package com.netcracker.crm.entity.controllerEntity.form;

import com.netcracker.crm.entity.User;

/**
 * Created by Ксения on 12.12.2016.
 */
public class ProfileForm {
    private String userName;
    private String contactPhone;
    private String contactAddress;

    public void setFieldsFromUser(User user){
        this.userName = user.getUserName();
        this.contactPhone = user.getContactPhone();
        this.contactAddress = user.getContactAddress();
    }

    public String getUserName() {
        if(userName==null) return "Lol";
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactPhone() {
        if(contactPhone==null) return "";
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactAddress() {
        if(contactAddress==null) return "";
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }
}
