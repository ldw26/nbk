package com.sbm.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户-基金详细类", description = "用户记录用户及其用户购买基金的详细信息")
public class UserFundList {

    @ApiModelProperty(value = "用户Id", name = "userId", dataType = "Integer", required = true, example = "1")
    private String fundId;

    @ApiModelProperty(value = "基金名称", name = "fundName", dataType = "String", required = true, example = "教育基金")
    private String fundName;

    @ApiModelProperty(value = "用户基金金额", name = "fundMoney", dataType = "String", required = true, example = "500")
    private String fundMoney;

    @ApiModelProperty(value = "基金年利率", name = "rate", dataType = "String", required = true, example = "0.04")
    private String rate;

    @ApiModelProperty(value = "用户购买基金的时间", name = "buyTime", dataType = "String", example = "20190714")
    private String buyTime;

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundMoney() {
        return fundMoney;
    }

    public void setFundMoney(String fundMoney) {
        this.fundMoney = fundMoney;
    }

    @Override
    public String toString() {
        return "UserFundList{" +
                "fundId='" + fundId + '\'' +
                ", fundName='" + fundName + '\'' +
                ", fundMoney='" + fundMoney + '\'' +
                ", rate='" + rate + '\'' +
                ", buyTime='" + buyTime + '\'' +
                '}';
    }
}
