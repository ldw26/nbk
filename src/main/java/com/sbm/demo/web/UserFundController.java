package com.sbm.demo.web;

import com.sbm.demo.bean.FundInfo;
import com.sbm.demo.bean.Login;
import com.sbm.demo.bean.UserFund;
import com.sbm.demo.service.FundInfoService;
import com.sbm.demo.service.UserFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserFundController {

    @Autowired
    private UserFundService userFundService;

    @Autowired
    private FundInfoService fundInfoService;

    //用户查询自己购买的基金存款数以及基金编号   method = RequestMethod.POST
    @RequestMapping(value = "bank/userfund/select/{userId}")
    @ResponseBody
    public UserFund loginSelect(@PathVariable Integer userId){
        List<UserFund> list = userFundService.selectOne(userId);

        UserFund userFund = new UserFund();
        Map<String,String> map = new HashMap<>();

        for (UserFund uf: list){
            Integer fundId = uf.getFundId();
            FundInfo fundInfo = fundInfoService.selectOne(fundId);
            map.put(fundId.toString(),fundInfo.getFundName());
        }
        userFund.setHashMap(map);
        return userFund;
    }

    //用户存基金
    @RequestMapping(value = "bank/userfund/updateadd")
    @ResponseBody
    public Boolean funUpdateAdd(@RequestBody UserFund userFund){



        return Boolean.TRUE;
    }


    //用户取基金
    @RequestMapping(value = "bank/userfund/updatecut")
    @ResponseBody
    public Boolean funUpdateCut(@RequestBody UserFund userFund){



        return Boolean.TRUE;
    }










}
