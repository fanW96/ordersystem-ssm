package com.ordersystem.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ordersystem.entity.User;
import com.ordersystem.service.UserService;
import com.ordersystem.util.Logger;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class UserAction extends ActionSupport implements SessionAware {
    public UserService userService=null;

    private User user;
    private List<User> users;
    public Map<String,Object> session;

    public String show() {
        return "show";
    }

    public String signup() {
        //todo username重复判断  flag无用
        int flag = userService.signup(user);
        if(flag!=0) {
            return "signup_success";
        }else {
            System.out.println("else="+flag);
        }
        //todo 验证是否注册成功
        return "signup";
    }

    public  String  login(){
        user=userService.login(this.user);
        if(user!=null){
            session.put("loginUser", user);
            return "login_success";
        }else {
//            Logger.out("error", "UserAction(login)"
//                    , "errors.login_noexist", "login button click");
            session.put("message", Logger.getMessage());
            System.out.println("kongde");
            return "login_failure";
        }
    }

    public String toRegister() {
        return "toRegister";
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
