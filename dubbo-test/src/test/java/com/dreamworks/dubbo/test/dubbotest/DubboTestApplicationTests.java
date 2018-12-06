package com.dreamworks.dubbo.test.dubbotest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dreamworks.dubbo.test.dubbotest.pojo.User;
import com.dreamworks.dubbo.test.dubbotest.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboTestApplicationTests {

    @Reference  //(url="dubbo://192.168.1.87:20880")
    private UserService service;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUserService(){
        User ret = service.getUserByID("123");
        assert ret != null;
        User ret1 = service.getUserByID("noexistid");
        assert  ret1 == null;
    }

}
