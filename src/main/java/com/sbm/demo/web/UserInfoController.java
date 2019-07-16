package com.sbm.demo.web;

//import com.alibaba.nacos.api.annotation.NacosInjected;
//import com.alibaba.nacos.api.exception.NacosException;
//import com.alibaba.nacos.api.naming.NamingService;
//import com.alibaba.nacos.api.naming.pojo.Instance;
//import java.util.List;
//import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.sbm.demo.bean.Login;
import com.sbm.demo.bean.Result;
import com.sbm.demo.bean.UserInfo;
import com.sbm.demo.service.LoginService;
import com.sbm.demo.service.MailService;
import com.sbm.demo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@Api(tags = "本类主要用于用户个人信息的注册、展示、修改等操作，还包括用户个人存款的变动")
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private MailService mailService;

    @ApiOperation(value="注册用户", notes="用户注册自己的详细信息（也就是插入这个用户），" +
            "其中用户名不能重复，如果重复，就返回注册失败信息")
    @ApiImplicitParam(name = "userInfo", value = "用户注册的信息实体类UserInfo", required = true, dataType = "UserInfo")
    @RequestMapping(value = "bank/userinfo/insert")
    @ResponseBody
    public Result loginInsert(@RequestBody UserInfo userInfo) {
        Result<Void> result = new Result();

        UserInfo userInfoResult1 = userInfoService.selectByUserName(userInfo.getUserName());
        if (userInfoResult1 != null ) {
            result.setFlag(Boolean.FALSE);
            return result;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String str = sdf.format(new Date());
        userInfo.setRegisterDate(str);
        int trueFalse = userInfoService.insert(userInfo);
        System.out.println("111111111111111111"+trueFalse);

        UserInfo userInfoResult2 = userInfoService.selectByUserName(userInfo.getUserName());
        //System.out.println("UserInfoController....userInfoResult......"+userInfoResult);

        Login login = new Login();
        login.setUserId(userInfoResult2.getUserId());
        login.setLogName(userInfoResult2.getUserName());
        login.setPassword(userInfoResult2.getPassword());
        loginService.insert(login);
        //System.out.println("UserInfoController....login......"+login);

        result.setFlag(Boolean.TRUE);

        String email = userInfo.getEmail();

        if (email != null) {
            String subject = "浙商银行新用户通知";
            String content = "恭喜您成为我行尊贵的客户，最近有很多新的理财产品推出，请登陆后前往基金市场查看！";
            try {
                mailService.sendSimpleMail(email, subject, content);
                System.out.println("emailllllllllllllllllllllll"+email);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @ApiOperation(value="更新用户", notes="更新用户（对有些字段的更新--如果写入）,如果对密码也更新了，" +
            "那么也相应更新到login表内")
    @ApiImplicitParam(name = "userInfo", value = "用户注册的信息实体类UserInfo", required = true, dataType = "UserInfo")
    @RequestMapping(value = "bank/userinfo/update")
    @ResponseBody
    public Result loginUpdate(@RequestBody UserInfo userInfo) {

        System.out.println("userInfooooooooooo"+userInfo);

        int trueFalse = userInfoService.update(userInfo);

        if (userInfo.getPassword()!=null){ //如果更新了密码了，那么相应更新到login表内
            Login login = new Login();
            login.setUserId(userInfo.getUserId());
            login.setPassword(userInfo.getPassword());
            System.out.println("loginnnnnnnnnnnnnnnn"+login);
            trueFalse = loginService.update(login);
        }

        Result<Void> result = new Result<>();

        if (trueFalse > 0) {
            result.setFlag(Boolean.TRUE);
        } else {
            result.setFlag(Boolean.FALSE);
        }
        return result;
    }

    @ApiOperation(value="删除用户", notes="删除用户（根据用户Id删除用户），相应在login表的数据删除")
    @ApiImplicitParam(name = "userInfo", value = "用户注册的信息实体类UserInfo", required = true, dataType = "UserInfo")
    @RequestMapping(value = "bank/userinfo/deletebyuserid")
    @ResponseBody
    public Result loginDeleteByuserId(@RequestBody UserInfo userInfo) {
        int userId = userInfo.getUserId();

        int trueFalse = userInfoService.delete(userId);
        trueFalse = loginService.delete(userId);
        Result<Void> result = new Result<>();

        if (trueFalse > 0) {
            result.setFlag(Boolean.TRUE);
        } else {
            result.setFlag(Boolean.FALSE);
        }
        return result;
    }

    //@ApiIgnore //使用该注解忽略这个API  --》Swagger里面的
    @ApiOperation(value="删除用户", notes="删除用户（根据用户名删除用户），相应在login表的数据删除")
    @ApiImplicitParam(name = "userInfo", value = "用户注册的信息实体类UserInfo", required = true, dataType = "UserInfo")
    @RequestMapping(value = "bank/userinfo/deletebyusername")
    @ResponseBody
    public Result loginDeleteByuserName(@RequestBody UserInfo userInfo) {
        String userName = userInfo.getUserName();

        int trueFalse = userInfoService.deleteByUserName(userName);
        trueFalse = loginService.deleteByUserName(userName);

        Result<Void> result = new Result<>();

        if (trueFalse > 0) {
            result.setFlag(Boolean.TRUE);
        } else {
            result.setFlag(Boolean.FALSE);
        }

        return result;
    }

    @ApiOperation(value = "查询用户",notes = "查询用户(根据用户名Id查询这个用户)")
    @ApiImplicitParam(name = "userInfo", value = "用户注册的信息实体类UserInfo", required = true, dataType = "UserInfo")
    @RequestMapping(value = "bank/userinfo/select")
    @ResponseBody
    public UserInfo loginSelect(@RequestBody UserInfo userInfo) {
        int userId = userInfo.getUserId();

        UserInfo userInfo1 = userInfoService.selectOne(userId);
        System.out.println(userInfo1);
        return userInfo1;
    }

    @ApiOperation(value = "用户存款的添加",notes = "用户存款的添加(根据用户名Id添加用户存款)," +
            "UserInfo类中只有两个参数：userId、deposit")
    @ApiImplicitParam(name = "userInfo", value = "用户注册的信息实体类UserInfo", required = true, dataType = "UserInfo")
    @RequestMapping(value = "bank/userinfo/depositadd")
    @ResponseBody
    public Result loginDepositAdd(@RequestBody UserInfo userInfo) {
        Result<Void> result = new Result<>();

        UserInfo userInfoResult = userInfoService.selectOne(userInfo.getUserId());
        //当前该用户的存款数
        double depositNow = Double.parseDouble(userInfoResult.getDeposit());
        //用户想要存入的存款数
        double depositAdd = Double.parseDouble(userInfo.getDeposit());
        //存入数据库的存款数（转成String类型）
        String depositDB = Double.toString((depositNow + depositAdd));

        userInfo.setDeposit(depositDB);
        int trueFalse = userInfoService.userDepositChange(userInfo);

        if (trueFalse > 0) {
            result.setFlag(Boolean.TRUE);
            return result;
        } else {
            result.setFlag(Boolean.FALSE);
            return result;
        }
    }

    @ApiOperation(value = "用户存款的取出",notes = "用户存款的取出(根据用户名Id取出用户存款), " +
                                     "UserInfo类中只有两个参数：userId、deposit")
    @ApiImplicitParam(name = "userInfo", value = "用户注册的信息实体类UserInfo", required = true, dataType = "UserInfo")
    @RequestMapping(value = "bank/userinfo/depositcut")
    @ResponseBody
    public Result loginDepositCut(@RequestBody UserInfo userInfo) {
        Result<Void> result = new Result<>();

        UserInfo userInfoResult = userInfoService.selectOne(userInfo.getUserId());
        //当前该用户的存款数
        double depositNow = Double.parseDouble(userInfoResult.getDeposit());
        //用户想要取出的存款数
        double depositCut = Double.parseDouble(userInfo.getDeposit());

        //取的钱小于存款数
        if (depositNow - depositCut > 0) {
            //存入数据库的存款数（转成String类型）
            String depositDB = Double.toString((depositNow - depositCut));
            userInfo.setDeposit(depositDB);
            userInfoService.userDepositChange(userInfo);
            result.setFlag(Boolean.TRUE);

        } else {//取的钱大于存款数，直接返回取款不成功
            result.setFlag(Boolean.FALSE);
        }

        return result;
    }


    //TODO 测试nacos作为SpringBoot的配置中心

//    @NacosValue(value = "${nacos.test.propertie:123}", autoRefreshed = true)
//    private String testProperties;
//
//    @RequestMapping("/test")
//    public String test(){
//        return testProperties;
//    }
//
//    // 注入 Nacos 的 NamingService 实例
//    @NacosInjected
//    private NamingService namingService;
//
//    /**
//     * 浏览器访问：http://127.0.0.1:8080/discovery/get?serviceName=nacos-springboot-discovery
//     *
//     * @param serviceName
//     * @return
//     * @throws NacosException
//     */
//    @RequestMapping(value = "/get")
//    @ResponseBody
//    public List<Instance> getInstance(@RequestParam String serviceName) throws NacosException {
//        return namingService.getAllInstances(serviceName);
//    }

}
