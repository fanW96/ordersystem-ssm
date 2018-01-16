package com.ordersystem.test;

import com.ordersystem.entity.User;
import com.ordersystem.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class OST {
    private UserService userService;

    @Test
    public void testSpringMybatis(){
        ApplicationContext atc =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (UserService) atc.getBean("userService");

        List<User> user = userService.showUserAll();
        for(User u : user) {
            System.out.println(u.toString());
        }
    }

    @Test
    public void testLogin() {
        ApplicationContext atc =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (UserService) atc.getBean("userService");

        User user = (User) atc.getBean("user");
        System.out.println(user.toString());
    }
}
