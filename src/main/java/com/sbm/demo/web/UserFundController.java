package com.sbm.demo.web;

import com.sbm.demo.bean.*;
import com.sbm.demo.service.FundInfoService;
import com.sbm.demo.service.UserFundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "本类主要用于用户查询自身购买的基金，以及购入转出已购基金")
@RestController
public class UserFundController {

    @Autowired
    private UserFundService userFundService;

    @Autowired
    private FundInfoService fundInfoService;

    @Autowired
    private UserInfoController userInfoController;

    @ApiOperation(value = "个人基金信息", notes = "用户查询自己购买的基金存款数以及基金名称")
    @ApiImplicitParam(name = "userFund", value = "用户个人-基金信息类", required = true, dataType = "UserFund")
    @RequestMapping(value = "bank/userfund/selectall")
    @ResponseBody  //UserFundList:fundID、fundName、fundMoney、rate、buyTime
    public List<UserFundList> loginSelect(@RequestBody UserFund userFund) {

        System.out.println("userIddddddddddddddddddd" + userFund.getUserId());
        List<UserFundList> list = userFundService.selectFundMoneyAndName(userFund.getUserId());

        return list;
    }

    @ApiOperation(value = "用户购入已购基金", notes = "用户自己购买已购基金，会检查存款数是否足够")
    @ApiImplicitParam(name = "userFund", value = "用户个人-基金信息类", required = true, dataType = "UserFund")
    @RequestMapping(value = "bank/userfund/updateadd")
    @ResponseBody //userFund里面含有userId、fundId、fundMoney
    public Result fundUpdateAdd(@RequestBody UserFund userFund) {
        Result<Void> result = new Result<>();

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userFund.getUserId());
        userInfo.setDeposit(userFund.getFundMoney());

        result = userInfoController.loginDepositCut(userInfo);

        //表明存款数大于要购买的基金数
        if (result.getFlag() == true) {

            //本来的基金数
            UserFund userFund1 = userFundService.selectOne(userFund.getUserId(), userFund.getFundId());
            //最终的基金数
            String resultMoney = String.valueOf(Double.parseDouble(userFund1.getFundMoney()) + Double.parseDouble(userFund.getFundMoney()));
            userFund.setFundMoney(resultMoney);

            userFundService.updateFundMoney(userFund);//只更新基金数
            result.setFlag(Boolean.TRUE);
        } else {//表明存款数小于要购买的基金数
            result.setFlag(Boolean.FALSE);
        }
        System.out.println("用户购入基金方法执行+++++++++++++++++++++");
        return result;
    }


    @ApiOperation(value = "用户取出已购基金", notes = "用户自己取出已购基金，会检查当前基金数是否足够")
    @ApiImplicitParam(name = "userFund", value = "用户个人-基金信息类", required = true, dataType = "UserFund")
    @RequestMapping(value = "bank/userfund/updatecut")
    @ResponseBody//userFund里面含有userId、fundId、fundMoney
    public Result fundUpdateCut(@RequestBody UserFund userFund) {
        Result<Void> result = new Result<>();

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userFund.getUserId());
        userInfo.setDeposit(userFund.getFundMoney());

        //本来的基金数
        UserFund userFund1 = userFundService.selectOne(userFund.getUserId(), userFund.getFundId());
        String fundMoney1 = userFund1.getFundMoney();

        //想要取出的基金数
        String fundMoney = userFund.getFundMoney();

        double resultMoney = Double.parseDouble(fundMoney1) - Double.parseDouble(fundMoney);

        //如果取出的基金数小于已有的基金数  -->能取出基金
        if (resultMoney > 0) {
            userFund.setFundMoney(String.valueOf(resultMoney));
            userFundService.updateFundMoney(userFund);//只更新基金数
            userInfoController.loginDepositAdd(userInfo);
            result.setFlag(Boolean.TRUE);
            System.out.println("Trueeeeeeeeeeeeeeee");
        } else { //如果取出的基金数大于已有的基金数  -->不能取出基金
            result.setFlag(Boolean.FALSE);
            System.out.println("Falseeeeeeeeeeeeeee");
        }
        return result;
    }

    @ApiOperation(value = "用户购入新基金", notes = "用户自己购入新基金，会检查是否已购入当前基金")
    @ApiImplicitParam(name = "userFund", value = "用户个人-基金信息类", required = true, dataType = "UserFund")
    @RequestMapping(value = "bank/userfund/insert")
    @ResponseBody//userFund里面含有userId、fundId、fundMoney
    public Result fundInsert(@RequestBody UserFund userFund) {
        Result<Void> result = new Result<>();

        UserFund userFund1 = userFundService.selectOne(userFund.getUserId(), userFund.getFundId());
        if (userFund1 != null) {
            result.setFlag(Boolean.FALSE);
            return result;  //已经购买本项基金了，所以直接返回false
        }

        int trueFalse = userFundService.insert(userFund);
        if (trueFalse > 0) {
            result.setFlag(Boolean.TRUE);
        } else {
            result.setFlag(Boolean.FALSE);
        }
        return result;
    }
}
