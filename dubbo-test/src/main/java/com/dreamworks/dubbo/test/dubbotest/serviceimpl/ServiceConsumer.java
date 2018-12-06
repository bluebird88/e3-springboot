package com.dreamworks.dubbo.test.dubbotest.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.dreamworks.dubbo.test.dubbotest.pojo.User;
import com.dreamworks.dubbo.test.dubbotest.service.UserReService;
import com.dreamworks.dubbo.test.dubbotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ServiceConsumer implements UserReService {

//    @Reference(url="dubbo://192.168.1.87:20880")o
    @Autowired
    private UserService service;


    @Override
    public void register(String userName, String id, int age) {
        User u = new User();
        u.setUserName(userName);
        u.setId(id);
        u.setAge(age);
        service.addUser(u);
    }

    @Override
    public User queryBy(String ID) {

        Object o = service.getUserByID(ID);

        return (User)o;
    }
}
