package com.sbm.demo.web;

import com.sbm.demo.bean.Login;
import com.sbm.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/bank/findAll")
    @ResponseBody
    public void findAll(@RequestBody Login login){
        System.out.println("111111"+login);

        Login login1 = loginService.selectOne(login.getUserId());

        System.out.println("2222222222222222222"+login1);
    }

    //登陆（查询这个用户）
    @GetMapping(value = "/bank/login/select")
    @ResponseBody
    public Boolean loginSelect(@RequestBody Login login){
        Login login1 = loginService.selectOne(login.getUserId());
        if (login1==null){
            return Boolean.FALSE;
        }else {
            return Boolean.TRUE;
        }
    }

}
