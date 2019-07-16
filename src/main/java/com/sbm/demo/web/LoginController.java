package com.sbm.demo.web;

import com.sbm.demo.bean.Login;
import com.sbm.demo.bean.Result;
import com.sbm.demo.service.LoginService;
import com.sbm.demo.utils.StringECC;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "本类主要用于个人信息的登陆查询使用")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value="用户登陆", notes="登陆（查询这个用户） 根据用户名和密码查找")
    @ApiImplicitParam(name = "login", value = "用户登陆实体类-Login", required = true, dataType = "Login")
    @RequestMapping(value = "bank/login/select")
    @ResponseBody
    public Result loginSelect(@RequestBody Login login){
        Result<Login> result = new Result();
        if(!StringECC.userNameAndPasswordECC(login)){ //用户名和密码属性存在为空的情况
            result.setFlag(Boolean.FALSE);
            return result;
        }

        Login login1 = loginService.selectOneByUserNameAndPassword(login.getLogName(),login.getPassword());
        //System.out.println("11111111111");

        if (login1==null){
            result.setFlag(Boolean.FALSE);
            System.out.println(false);
        }else {
            result.setData(login1);
            result.setFlag(Boolean.TRUE);
            System.out.println(true);
        }
        return result;
    }
}
