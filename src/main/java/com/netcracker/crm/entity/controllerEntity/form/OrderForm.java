package com.netcracker.crm.entity.controllerEntity.form;

import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.serviceEntity.Order;

/**
 * Created by Ксения on 06.12.2016.
 */
public class OrderForm {
    String contactName;
    String contactPhone;
    String contactAddress;
    String description;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFieldsFromUser(User user){
        this.contactName = user.getUserName();
        this.contactPhone = user.getContactPhone();
        this.contactAddress = user.getContactAddress();
    }
}
