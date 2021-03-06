package com.ordersystem.mapper;

import com.ordersystem.entity.User;
import java.util.List;

public interface UserMapper {
    public int addUser(User user);
    public int removeUser(User user);
    public  User   showUserById(User user);
    public int  editUserByUser(User user);
    public List<User> showUserAll();
    public User login(User user);
    public int signup(User user);
}
