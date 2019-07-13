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
    @RequestMapping(value = "bank/userinfo/insert")
    @ResponseBody
    public Boolean loginInsert(@RequestBody UserInfo userInfo){

        int result = userInfoService.insert(userInfo);

        Login login = new Login();
        login.setUserId(userInfo.getUserId());
        login.setLogName(userInfo.getUserName());
        login.setPassword(userInfo.getPassword());
        result = loginService.insert(login);

        if (result>0){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    //更新用户
    @RequestMapping(value = "bank/userinfo/update")
    @ResponseBody
    public Boolean loginUpdate(@RequestBody UserInfo userInfo){

        int result =userInfoService.update(userInfo);

        Login login = new Login();
        login.setUserId(userInfo.getUserId());
        login.setLogName(userInfo.getUserName());
        login.setPassword(userInfo.getPassword());

        result = loginService.update(login);

        if (result>0){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    //删除用户（根据yonghuId删除用户）
    @RequestMapping(value = "bank/userinfo/delete/{userId}")
    @ResponseBody
    public Boolean loginDelete(@PathVariable Integer userId){

        int result = userInfoService.delete(userId);

        result = loginService.delete(userId);

        if (result>0){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    //查询用户(根据用户名Id查询这个用户)
    @RequestMapping(value = "bank/userinfo/select/{userId}")
    @ResponseBody
    public UserInfo loginSelect(@PathVariable Integer userId){

        UserInfo userInfo = userInfoService.selectOne(userId);
        return userInfo;
    }
}
