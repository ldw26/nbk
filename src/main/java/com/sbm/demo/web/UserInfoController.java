package com.sbm.demo.web;

import com.sbm.demo.bean.Login;
import com.sbm.demo.bean.UserInfo;
import com.sbm.demo.service.LoginService;
import com.sbm.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LoginService loginService;

    //注册（也就是插入这个用户）   method = RequestMethod.POST
    @GetMapping(value = "/bank/userinfo/insert")
    @ResponseBody
    public void loginInsert(@RequestBody UserInfo userInfo){

        userInfoService.insert(userInfo);

        Login login = new Login();
        login.setUserId(userInfo.getUserId());
        login.setLogName(userInfo.getUserName());
        login.setPassword(userInfo.getPassword());
        loginService.insert(login);
    }

    //更新用户
    @GetMapping(value = "/bank/userinfo/update")
    @ResponseBody
    public void loginUpdate(@RequestBody UserInfo userInfo){

        userInfoService.update(userInfo);

        Login login = new Login();
        login.setUserId(userInfo.getUserId());
        login.setLogName(userInfo.getUserName());
        login.setPassword(userInfo.getPassword());
        loginService.update(login);
    }

    //删除用户
    @GetMapping(value = "/bank/userinfo/delete")
    @ResponseBody
    public void loginDelete(@RequestBody Integer userId){

        userInfoService.delete(userId);

        loginService.delete(userId);
    }

    //查询用户
    @GetMapping(value = "/bank/userinfo/select")
    @ResponseBody
    public UserInfo loginSelect(@RequestBody Integer userId){

        return userInfoService.selectOne(userId);
    }

}
