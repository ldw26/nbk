package com.sbm.demo.web;

import com.sbm.demo.bean.Login;
import com.sbm.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    //登陆（查询这个用户） 根据用户名和密码查找
    @RequestMapping(value = "bank/login/select")
    @ResponseBody
    public String loginSelect(@RequestBody Login login){

        Login login1 = loginService.selectOneByUserNameAndPassword(login.getLogName(),login.getPassword());

        if (login1==null){
            return Boolean.FALSE+"";
        }else {
            return Boolean.TRUE+login1.getUserId().toString();
        }
    }

}
