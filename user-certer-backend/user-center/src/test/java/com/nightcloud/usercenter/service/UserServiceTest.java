package com.nightcloud.usercenter.service;

import com.nightcloud.usercenter.model.entity.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;
    
    @Test
    void testAddUser() {
        User user = new User();
        user.setUsername("xiaobai");
        user.setUserAccount("123");
        user.setAvatarUrl("https://cn.bing.com/images/" +
                "search?q=%E5%A4%B4%E5%83%8F&FORM=IQFRBA&id=15E6ABE13B73198BE558422E3C9BF57317AA4F3E");
        user.setGender(0);
        user.setUserPassword("123456");
        user.setPhone("1234567890");
        user.setEmail("123456@qq.com");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void testUserRegister() {
        String userAccount = "xiaobai";
        String userPassword = "";
        String checkPassword = "123456";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "xiao";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "xiaobai";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "xiao bai";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "cloudxiaobai";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "xiaobai";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertTrue(result > 0);
    }
}