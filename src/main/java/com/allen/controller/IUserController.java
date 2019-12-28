package com.allen.controller;


import com.allen.entity.User;

public interface IUserController {

    User getUserByName(String name);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

}


