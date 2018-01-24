package com.ordersystem.service.impl;

import com.ordersystem.entity.User;
import com.ordersystem.mapper.UserMapper;
import com.ordersystem.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    public User login(User user) {
        return userMapper.login(user);
    }

    public int signup(User user) {
        return userMapper.signup(user);
    }

    public int addUser(User user) {
        return 0;
    }

    public int removeUser(User user) {
        return 0;
    }

    public User showUserById(User user) {
        return null;
    }

    public int editUserByUser(User user) {
        return 0;
    }

    public List<User> showUserAll() {
        return userMapper.showUserAll();
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }
}
