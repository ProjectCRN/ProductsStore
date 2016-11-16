package com.netcracker.crm.entity;

import java.io.Serializable;

/**
 * Created by egor on 24.10.2016.
 */
public class User extends AbstractEntity{

    private static final long serialVersionUID = 1L;
    public static final String ROLE_ADMIN = "A";
    public static final String ROLE_USER = "U";

    private String login;
    private String password;
    private String userName;
    private String contactPhone;
    private String contactAddress;
    private String roleId;

    public User(){}

    public User(int id, String login, String password, String userName, String contactPhone, String contactAddress, String roleId) {
        super(id);
        this.login = login;
        this.password = password;
        this.userName = userName;
        this.contactPhone = contactPhone;
        this.contactAddress = contactAddress;
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (contactPhone != null ? !contactPhone.equals(user.contactPhone) : user.contactPhone != null) return false;
        if (contactAddress != null ? !contactAddress.equals(user.contactAddress) : user.contactAddress != null)
            return false;
        return roleId.equals(user.roleId);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int prime = 31;
        result = prime * result + getId();
        result = prime * result + login.hashCode();
        result = prime * result + password.hashCode();
        result = prime * result + (userName != null ? userName.hashCode() : 0);
        result = prime * result + (contactPhone != null ? contactPhone.hashCode() : 0);
        result = prime * result + (contactAddress != null ? contactAddress.hashCode() : 0);
        result = prime * result + roleId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + getId() +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

        this.contactPhone = (contactPhone != null ? contactPhone : "null");

    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = (contactAddress != null ? contactAddress : "null");
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
