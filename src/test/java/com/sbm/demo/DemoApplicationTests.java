package com.sbm.demo;

import com.sbm.demo.bean.Login;
import com.sbm.demo.bean.UserInfo;
import com.sbm.demo.service.UserInfoService;
import com.sbm.demo.web.LoginController;
import com.sbm.demo.web.UserInfoController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserInfoController userInfoController;

    @Autowired
    private LoginController loginController;

    @Test
    public void contextLoads() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(66);
        userInfo.setPassword("science");
        userInfo.setUserName("xiaowang");
        //userInfo.setEmail("540106935@qq.com");
        userInfo.setRegisterDate("20190701");
        //userInfo.setAdress("123456");
        userInfo.setPhoneNumber("156897847");
        userInfo.setProfession("医生");
        userInfo.setSex("male");
        //userInfo.setDeposit("12345");

        Login login = new Login();
        login.setUserId(11);
        login.setLogName("111");
        login.setPassword("1234");

        System.out.println("Testttttttttttt"+userInfoController.loginInsert(userInfo));

        System.out.println("Testttttttttttt"+userInfoController.loginDelete(userInfo.getUserId()));
    }

}
