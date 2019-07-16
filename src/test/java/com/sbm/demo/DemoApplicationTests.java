package com.sbm.demo;

import com.sbm.demo.bean.*;
import com.sbm.demo.service.MailService;
import com.sbm.demo.service.UserInfoService;
import com.sbm.demo.web.FundInfoController;
import com.sbm.demo.web.LoginController;
import com.sbm.demo.web.UserFundController;
import com.sbm.demo.web.UserInfoController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import javax.mail.MessagingException;
import java.io.File;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserInfoController userInfoController;

    @Autowired
    private LoginController loginController;

    @Autowired
    private UserFundController userFundController;

    @Autowired
    private FundInfoController fundInfoController;

    @Autowired
    private MailService mailService;

    //TODO 关于用户信息的test
    @Test
    public void contextLoads() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(5);
//        userInfo.setPassword("math123");
//        userInfo.setUserName("laowang");
//        userInfo.setEmail("540106935@qq.com");
//        userInfo.setRegisterDate("20190701");
//        userInfo.setAdress("山西");
//        userInfo.setPhoneNumber("156897847");
//        userInfo.setProfession("老师");
//        userInfo.setSex("male");
//        userInfo.setIdCard("33048215571547");
//        userInfo.setName("老张");
        userInfo.setDeposit("300000");

        Login login = new Login();
        login.setLogName("xiaogang123");
        login.setPassword("123456");

        //System.out.println("Testtttt用户登陆是否成功ttttttt"+loginController.loginSelect(login));

        //System.out.println("Testttt用户注册是否成功tttttttt"+userInfoController.loginInsert(userInfo));

        //System.out.println("Testttt用户注销自己账号是否成功tttttttt"+userInfoController.loginDeleteByuserId(342));

        //System.out.println("Testtt用户信息的展示是否成功ttttttttt"+userInfoController.loginSelect(1));

        //System.out.println("Testt用户信息的修改是否成功tttttttttt"+userInfoController.loginUpdate(userInfo));

        //TODO 用户存款添加测试
        //System.out.println("Testttttttttttt"+userInfoController.loginDepositAdd(userInfo));

        //TODO 用户存款取出测试
        System.out.println("Testttttttttttt"+userInfoController.loginDepositCut(userInfo));
    }

    //TODO 关于用户-基金的test
    @Test
    public void userFund(){
        UserFund userFund = new UserFund();

        userFund.setUserId(1);
        userFund.setFundId(1003);
        userFund.setBuyTime("20170714");
        userFund.setFundMoney("50000");

        //System.out.println("Testttttt测试基金信息的查询tttttttt"+fundInfoController.selectAllFund());

        //System.out.println("Testttttt测试基金池所有基金的查询tttttttt"+fundInfoController.selectAllFundView());

        System.out.println("Testttt用户查看自己购买的基金及其信息ttttttttt"+userFundController.loginSelect(userFund));

        //System.out.println("Testttt用户购买已购基金测试ttttttttt"+userFundController.fundUpdateAdd(userFund));

        //System.out.println("Testttt用户取出已购基金测试ttttttttt"+userFundController.fundUpdateCut(userFund));

        //System.out.println("Testttt用户新购基金测试ttttttttt"+fundInfoController.addFund(userFund));
    }


    @Test
    public void testMail() {
        String to = "540106935@qq.com";
        String subject = "今晚要加班，不用等我了";
        String rscId = "img110";
        String content = "<html><body><img width='250px' src=\'cid:" + rscId + "\'></body></html>";


        try {
            File sourceFile = ResourceUtils.getFile("classpath:static/images/bankin.jpg"); //这种方法在linux下无法工作
            //mailService.sendInlineResourceMail(to,subject,content,sourceFile,rscId);
            mailService.sendSimpleMail(to,subject,"hahahahhahahaa");
            System.out.println("成功了");
        } catch (Exception e) {
            System.out.println("失败了");
            e.printStackTrace();
        }
    }

}
