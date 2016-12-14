package com.netcracker.crm.entity.controllerEntity.form;

import com.netcracker.crm.entity.User;


public class OrderForm {
    String contactName;
    String contactPhone;
    String contactAddress;

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


    public void setFieldsFromUser(User user) {
        this.contactName = user.getUserName();
        this.contactPhone = user.getContactPhone();
        this.contactAddress = user.getContactAddress();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderForm)) return false;

        OrderForm orderForm = (OrderForm) o;

        if (getContactName() != null ? !getContactName().equals(orderForm.getContactName()) : orderForm.getContactName() != null)
            return false;
        if (getContactPhone() != null ? !getContactPhone().equals(orderForm.getContactPhone()) : orderForm.getContactPhone() != null)
            return false;
        return getContactAddress() != null ? getContactAddress().equals(orderForm.getContactAddress()) : orderForm.getContactAddress() == null;

    }

    @Override
    public int hashCode() {
        int result = getContactName() != null ? getContactName().hashCode() : 0;
        result = 31 * result + (getContactPhone() != null ? getContactPhone().hashCode() : 0);
        result = 31 * result + (getContactAddress() != null ? getContactAddress().hashCode() : 0);
        return result;
    }

    public OrderForm(String contactName, String contactPhone, String contactAddress) {
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactAddress = contactAddress;
    }

    public OrderForm() {
    }
}
