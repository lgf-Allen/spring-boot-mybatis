package com.allen.controller;

import com.alibaba.fastjson.JSON;
import com.allen.entity.User;
import com.allen.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserControllerImpl implements IUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerImpl.class);

    @Autowired
    private IUserService userService;

    @GetMapping
    @Override
    public User getUserByName(@RequestParam("name") String name) {
        LOGGER.info("Search user by name: {}", name);
        User user = userService.getUserByName(name);
        LOGGER.info("Found user is {}", JSON.toJSONString(user));
        return user;
    }

    @PostMapping
    @Override
    public void createUser(@RequestBody User user) {
        userService.insertUserInfo(user.getName(), user.getAge());
        LOGGER.info("create user is {}", JSON.toJSONString(user));
    }

    @PutMapping
    @Override
    public void updateUser(@RequestBody User user) {
        LOGGER.info("updateUser by user:{}", JSON.toJSONString(user));
        userService.updateUser(user);
    }

    @DeleteMapping
    @Override
    public void deleteUser(@RequestParam("id") Long id) {
        LOGGER.info("deleteUser by id:{}", id);
        userService.deleteUser(id);
    }

}
