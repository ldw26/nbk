package com.sbm.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "用户-基金类", description = "用户记录用户及其用户购买基金的信息")
public class UserFund {

    @ApiModelProperty(value = "用户Id", name = "userId", dataType = "Integer", required = true, example = "1")
    private Integer userId;

    @ApiModelProperty(value = "基金Id", name = "fundId", dataType = "Integer", required = true, example = "1001")
    private Integer fundId;

    @ApiModelProperty(value = "用户购买基金的时间", name = "buyTime", dataType = "String", example = "20190714")
    private String buyTime;

    @ApiModelProperty(value = "用户基金金额", name = "fundMoney", dataType = "String", required = true, example = "500")
    private String fundMoney;

    public String getFundMoney() {
        return fundMoney;
    }

    public void setFundMoney(String fundMoney) {
        this.fundMoney = fundMoney;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    @Override
    public String toString() {
        return "UserFund{" +
                "userId=" + userId +
                ", fundId=" + fundId +
                ", buyTime='" + buyTime + '\'' +
                ", fundMoney='" + fundMoney + '\'' +
                '}';
    }
}
