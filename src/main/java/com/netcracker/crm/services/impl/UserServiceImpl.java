package com.netcracker.crm.services.impl;

import com.netcracker.crm.dao.IUserDao;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.services.AbstractService;
import com.netcracker.crm.services.IUserService;
import com.netcracker.crm.services.constants.ServiceConstants;
import com.netcracker.crm.services.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;
import java.util.Map;


public class UserServiceImpl extends AbstractService<User> implements IUserService {

    private IUserDao userDao;

    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Required
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int add(User user) throws ServiceException {
        int id;
        try {
            id = userDao.add(user);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " add " + user.toString());
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return id;
    }

    @Override
    public User getById(int id) throws ServiceException {
        User user;
        try {
            user = userDao.getById(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getById " + user.toString());
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return user;
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            userDao.delete(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " delete User #" + id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public List<User> getAll() throws ServiceException {
        List<User> list;
        try {
            list = userDao.getAll();
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getAll");
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return list;
    }

    @Override
    public List<User> getAllByRole(String roleId) throws ServiceException {
        List<User> list;
        try {
            list = userDao.getAllByRole(roleId);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getAllByRoleId #" + roleId);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return list;
    }

    @Override
    public Map<Integer, String> login(String login) throws ServiceException {
        return null;
    }

    @Override
    public void update(int id, String uLogin, String uPassword, String uName, String uPhone, String uAddress, String uEmail) throws ServiceException {
        try {
            userDao.update(id, uLogin, uPassword, uName, uPhone, uAddress, uEmail);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " update user #" + id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean isLoginFree(String login) throws ServiceException {
        boolean is;
        try {
            is = userDao.isLoginFree(login);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " login " + login + " isFree: " + is);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return is;
    }

    @Override
    public boolean isEmailFree(String email) throws ServiceException {
        boolean is;
        try {
            is = userDao.isEmailFree(email);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " email " + email + " isFree: " + is);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return is;
    }

    @Override
    public int getIdByLogin(String login) throws ServiceException {
        int userId = -100;
        try {
            userId = userDao.getIdByLogin(login);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED + " getIdByLogin " + userId);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return userId;
    }

    @Override
    public String hashing(String str) {
        return (userDao.hashing(str));
    }

}
