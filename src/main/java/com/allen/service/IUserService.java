package com.allen.service;


import com.allen.entity.User;

public interface IUserService {

    User getUserByName(String name);

    void insertUserInfo(String name, Integer age);

    void updateUser(User user);

    void deleteUser(Long id);
}
