package com.netcracker.crm.dao;

import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by egor on 11.11.2016.
 */
public interface IUserDao extends IDao<User>{
    List<User> getAll() throws DaoException;
    List<User> getAllByRole(String roleId) throws DaoException;
    Map<Integer, String> login(String login) throws DaoException;
    void update(int id, String uLogin, String uPassword, String uName,
                       String uPhone, String uAddress, String uEmail) throws DaoException;
    boolean isLoginFree(String login) throws DaoException;
    boolean isEmailFree(String email) throws DaoException;
}
