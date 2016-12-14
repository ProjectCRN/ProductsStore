package com.netcracker.crm.entity;


public class User extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    public static final String ROLE_ADMIN = "A";
    public static final String ROLE_USER = "U";
    public static final String ROLE_ANON = "N";

    private String login;
    private String password;
    private String userName;
    private String contactPhone;
    private String contactAddress;
    private String roleId;
    private String email;

    public User() {
    }

    public User(int id, String login, String password, String userName, String contactPhone, String contactAddress, String roleId, String email) {
        super(id);
        this.login = login;
        this.password = password;
        this.userName = userName;
        this.contactPhone = contactPhone;
        this.contactAddress = contactAddress;
        this.roleId = roleId;
        this.email = email;
    }

    public void clone(User user) {
        this.setId(user.getId());
        this.setLogin(user.getLogin());
        this.setPassword(user.getPassword());
        this.setUserName(user.getUserName());
        this.setContactPhone(user.getContactPhone());
        this.setContactAddress(user.getContactAddress());
        this.setRoleId(user.getRoleId());
        this.setEmail(user.getEmail());
    }

    public boolean isAdmin() {
        return this.getRoleId().equals(User.ROLE_ADMIN);
    }

    public boolean isUser() {
        return this.getRoleId().equals(User.ROLE_USER);
    }

    public boolean isAnon() {
        return this.getRoleId().equals(User.ROLE_ANON);
    }

    public void logout() {
        this.setId(-1);
        this.setLogin("anon");
        this.setPassword("anon");
        this.setUserName("Guest");
        this.setContactPhone("");
        this.setContactAddress("");
        this.setRoleId(User.ROLE_ANON);
        this.setEmail("anon@gmail.com");
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
        if (email != null ? !email.equals(user.email) : user.email != null)
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
        result = prime * result + (email != null ? email.hashCode() : 0);
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
                ", email='" + email + '\'' +
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
