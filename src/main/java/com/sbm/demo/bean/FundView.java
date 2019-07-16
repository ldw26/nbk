package com.sbm.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "实时基金视图类",description = "对实时基金信息的描述")
public class FundView {

    @ApiModelProperty(value = "基金Id",name = "fundId",dataType = "Integer",required = true,example = "1001")
    private Integer fundId;

    @ApiModelProperty(value = "基金名称",name = "fundName",dataType = "String",required = true,example = "教育基金")
    private String fundName;

    @ApiModelProperty(value = "有些基金每日须投入的钱",name = "dailyMoney",dataType = "String",example = "2")
    private String dailyMoney;

    @ApiModelProperty(value = "基金年利率",name = "rate",dataType = "String",required = true,example = "0.04")
    private String rate;

    @ApiModelProperty(value = "基金类型",name = "lock",dataType = "String",required = true,example = "0")
    private String lock;

    @ApiModelProperty(value = "该项基金购买人数",name = "fundPeople",dataType = "String",required = true,example = "3")
    private String fundPeople;

    @ApiModelProperty(value = "该项基金总购买总量",name = "fundLoop",dataType = "String",required = true,example = "9773.864")
    private String fundLoop;

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getDailyMoney() {
        return dailyMoney;
    }

    public void setDailyMoney(String dailyMoney) {
        this.dailyMoney = dailyMoney;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public String getFundPeople() {
        return fundPeople;
    }

    public void setFundPeople(String fundPeople) {
        this.fundPeople = fundPeople;
    }

    public String getFundLoop() {
        return fundLoop;
    }

    public void setFundLoop(String fundLoop) {
        this.fundLoop = fundLoop;
    }

    @Override
    public String toString() {
        return "FundView{" +
                "fundId=" + fundId +
                ", fundName='" + fundName + '\'' +
                ", dailyMoney='" + dailyMoney + '\'' +
                ", rate='" + rate + '\'' +
                ", lock='" + lock + '\'' +
                ", fundPeople='" + fundPeople + '\'' +
                ", fundLoop='" + fundLoop + '\'' +
                '}';
    }
}
