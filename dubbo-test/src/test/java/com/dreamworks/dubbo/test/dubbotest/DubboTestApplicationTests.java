package com.dreamworks.dubbo.test.dubbotest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dreamworks.dubbo.test.dubbotest.pojo.User;
import com.dreamworks.dubbo.test.dubbotest.service.UserReService;
import com.dreamworks.dubbo.test.dubbotest.service.UserService;
import com.dreamworks.dubbo.test.dubbotest.serviceimpl.ServiceConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class DubboTestApplicationTests {

    @Reference  //(url="dubbo://192.168.1.87:20880")
    private UserService service;

    @Reference
    private UserReService svr;


    @Test
    public void contextLoads() {
    }

    @Test
    public void testUserService(){
        service.addUser(null);
        User ret = service.getUserByID("123");
        assert ret != null;
        User ret1 = service.getUserByID("noexistid");
        assert  ret1 == null;
    }

    @Test
    public void directInstanceService(){
//        UserReService svr = new ServiceConsumer();
        User ret = svr.queryBy("123");
        assert ret != null;
        User ret1 = svr.queryBy("ss");
        assert ret1 == null;
    }

}
