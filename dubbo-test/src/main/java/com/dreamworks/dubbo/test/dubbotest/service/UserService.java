package com.dreamworks.dubbo.test.dubbotest.service;

import com.dreamworks.dubbo.test.dubbotest.pojo.User;

public interface UserService {

    public void addUser(User user);

    public User getUserByID(String id) ;

}
