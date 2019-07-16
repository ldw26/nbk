package com.sbm.demo.web;

import com.sbm.demo.bean.*;
import com.sbm.demo.service.FundInfoService;
import com.sbm.demo.service.FundViewService;
import com.sbm.demo.service.UserFundService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "本类主要用于基金详细信息的展示，包括通过数据库的视图来进行实时的基金信息展示")
@RestController
public class FundInfoController {

    @Autowired
    private FundInfoService fundInfoService;

    @Autowired
    private UserFundService userFundService;

    @Autowired
    private UserInfoController userInfoController;

    @Autowired
    private UserFundController userFundController;

    @Autowired
    private FundViewService fundViewService;

    @ApiOperation(value="基金信息查询", notes="查看所有的基金详细信息")
    @RequestMapping(value = "bank/fundinfo/selectallfund")
    @ResponseBody
    public List<FundInfo> selectAllFund() {
        return fundInfoService.selectAll();
    }

    @ApiOperation(value = "用户购入新基金", notes = "用户自己购入新基金，" +
            "会检查是否已购入当前基金（金钱数为0也可以，不为0也可以）")
    @ApiImplicitParam(name = "userFund", value = "用户-基金信息实体类", required = true, dataType = "UserFund")
    @RequestMapping(value = "bank/fundinfo/addfund")
    public Result addFund(@RequestBody UserFund userFund) {
        Result<Void> result = new Result<>();

        //判断用户是否已经购买该项基金
        UserFund tureFalse = userFundService.selectOne(userFund.getUserId(), userFund.getFundId());
        if (tureFalse != null) {
            result.setFlag(Boolean.FALSE); //因为已经购买该项基金，所以购买基金失败
            return result;
        }

        //用户想要购买的基金的金钱数
        String fundMoney = userFund.getFundMoney();

        //判断用户个人存款是否足够购买
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userFund.getUserId());
        userInfo.setDeposit(userFund.getFundMoney());
        Result<Void> resultFundMoney = userInfoController.loginDepositCut(userInfo);
        if (resultFundMoney.getFlag() == true) { //个人存款足够购买
            result = userFundController.fundInsert(userFund);
        } else { //个人存款不足够购买
            result.setFlag(Boolean.FALSE);
        }
        return result;
    }


    @ApiOperation(value = "实时基金信息查看", notes = "使用视图用户查看基金池的状态 ---》" +
            "包含基金名称，基金购买人数，基金购买总量")
    @RequestMapping(value = "bank/fundinfo/fundview")
    public List<FundView> selectAllFundView(){
        return fundViewService.selectAll();
    }

}
