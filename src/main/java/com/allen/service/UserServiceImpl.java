package com.allen.service;

import com.allen.dao.IUserDao;
import com.allen.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    public User getUserByName(String name){
        return userDao.getUserByName(name);
    }

    public void insertUserInfo(String name, Integer age){
        userDao.insertUser(name, age);
    }

    @Override
    public void updateUser(User user) {
        userDao.updatUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUserById(id);
    }
}
