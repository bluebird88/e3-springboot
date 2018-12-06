package com.dreamworks.dubbo.test.dubbotest.serviceimpl;

import com.dreamworks.dubbo.test.dubbotest.pojo.User;
import com.dreamworks.dubbo.test.dubbotest.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;


@Service
public class UserServiceImple implements UserService {

    @Override
    public void addUser(User user) {

    }

    @Override
    public User getUserByID(String id) {
        if(!id.equals("123")) return null;
        User ret = new User();
        ret.setId(id);
        ret.setAge(12);
        ret.setUserName("yanhk");
        return ret;
    }

    public UserServiceImple() {
    }

}
