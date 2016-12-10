package com.netcracker.crm.services;

import com.netcracker.crm.entity.User;
import com.netcracker.crm.services.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * Created by egor on 11.11.2016.
 */
public interface IUserService extends IService<User>{
     List<User> getAll() throws ServiceException;
     List<User> getAllByRole(String roleId) throws ServiceException;
     Map<Integer, String> login(String login) throws ServiceException;
     void update(int id, String uLogin, String uPassword, String uName,
                       String uPhone, String uAddress, String uEmail) throws ServiceException;
     boolean isLoginFree(String login);
     boolean isEmailFree(String email)  throws ServiceException;
     int getIdByLogin(String login)  throws ServiceException;
    String hashing(String str);
}
