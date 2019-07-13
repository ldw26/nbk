package com.sbm.demo.web;

import com.sbm.demo.bean.FundInfo;
import com.sbm.demo.bean.UserFund;
import com.sbm.demo.service.FundInfoService;
import com.sbm.demo.service.UserFundService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FundInfoController {

    @Autowired
    private FundInfoService fundInfoService;

    @Autowired
    private UserFundService userFundService;

    //查看所有的基金信息
    @RequestMapping(value ="bank/fundinfo/selectAll")
    @ResponseBody
    public List<FundInfo> selectAll(){
         return fundInfoService.selectAll();
    }

    //用户添加某项基金
    @RequestMapping(value = "bank/fundinfo/adfund")
    public Boolean addFund(@RequestBody UserFund userFund){
        int result = userFundService.insert(userFund);
        if (result>0){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

}
