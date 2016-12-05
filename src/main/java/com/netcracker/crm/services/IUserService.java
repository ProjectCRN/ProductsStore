package com.netcracker.crm.services;

import com.netcracker.crm.entity.User;
import com.netcracker.crm.services.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * Created by egor on 11.11.2016.
 */
public interface IUserService extends IService<User>{
    public List<User> getAll() throws ServiceException;
    public List<User> getAllByRole(String roleId) throws ServiceException;
    public Map<Integer, String> login(String login) throws ServiceException;
    public void update(int id, String uLogin, String uPassword, String uName,
                       String uPhone, String uAddress, String uEmail) throws ServiceException;
    public boolean isLoginFree(String login);
    public boolean isEmailFree(String email)  throws ServiceException;
    public int getIdByLogin(String login)  throws ServiceException;
}
