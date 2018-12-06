package com.dreamworks.dubbo.test.dubbotest.service;

import com.dreamworks.dubbo.test.dubbotest.pojo.User;

public interface UserReService {
    public void register(String userName,String id,int age);

    public User queryBy(String ID);
}
