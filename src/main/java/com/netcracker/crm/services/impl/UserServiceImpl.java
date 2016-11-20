package com.netcracker.crm.services.impl;

import com.netcracker.crm.dao.IUserDao;
import com.netcracker.crm.dao.exception.DaoException;
import com.netcracker.crm.dao.impl.UserDaoImpl;
import com.netcracker.crm.entity.User;
import com.netcracker.crm.services.AbstractService;
import com.netcracker.crm.services.IUserService;
import com.netcracker.crm.services.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by egor on 11.11.2016.
 */

@Service
public class UserServiceImpl extends AbstractService<User> implements IUserService{

    @Autowired
    private IUserDao userDao;

    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);


    @Override
    public int add(User user) {
        int id;
        try {
            id = userDao.add(user);

        } catch (DaoException e){
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return id;
    }

    @Override
    public User getById(int id) {
        User user;
        try {
            user = userDao.getById(id);
        } catch (DaoException e){
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return user;
    }

    @Override
    public void delete(int id) {
        try {
            userDao.delete(id);
        } catch (DaoException e){
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public List<User> getAll() {
        List<User> list;
        try {
            list = userDao.getAll();
        } catch (DaoException e){
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return list;
    }

    @Override
    public List<User> getAllByRole(String roleId) {
        List<User> list;
        try {
            list = userDao.getAllByRole(roleId);
        } catch (DaoException e){
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return list;
    }

    @Override
    public Map<Integer, String> login(String login) {
        return null;
    }

    @Override
    public void update(int id, String uLogin, String uPassword, String uName, String uPhone, String uAddress){
        try {
            userDao.update(id, uLogin, uPassword, uName, uPhone, uAddress);
        } catch (DaoException e){
            logger.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean isLoginFree(String login) {
        boolean is;
       try {
            is = userDao.isLoginFree(login);
        } catch (DaoException e){
           logger.error(e.getMessage());
           throw new ServiceException(e.getMessage(), e);
        }
        return is;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

}
