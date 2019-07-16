package com.sbm.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "基金信息类", description = "对基金信息的描述")
public class FundInfo {

    @ApiModelProperty(value = "基金Id", name = "fundId", dataType = "Integer", required = true, example = "1001")
    private Integer fundId;

    @ApiModelProperty(value = "基金名称", name = "fundName", dataType = "String", required = true, example = "教育基金")
    private String fundName;

    @ApiModelProperty(value = "有些基金每日须投入的钱", name = "dailyMoney", dataType = "String", example = "2")
    private String dailyMoney;

    @ApiModelProperty(value = "基金年利率", name = "rate", dataType = "String", required = true, example = "0.04")
    private String rate;

    @ApiModelProperty(value = "基金类型", name = "lock", dataType = "String", required = true, example = "0")
    private String lock;

    @ApiModelProperty(value = "基金介绍", name = "fundIntroduction", dataType = "String", required = true, example = "。。。")
    private String fundIntroduction;

    public String getFundIntroduction() {
        return fundIntroduction;
    }

    public void setFundIntroduction(String fundIntroduction) {
        this.fundIntroduction = fundIntroduction;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

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

    @Override
    public String toString() {
        return "FundInfo{" +
                "fundId=" + fundId +
                ", fundName='" + fundName + '\'' +
                ", dailyMoney='" + dailyMoney + '\'' +
                ", rate='" + rate + '\'' +
                ", lock='" + lock + '\'' +
                ", fundIntroduction='" + fundIntroduction + '\'' +
                '}';
    }
}
