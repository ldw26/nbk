package com.sbm.demo.bean;

public class FundInfo {
    private Integer fundId;
    private String fundName;
    private String dailyMoney;
    private String rate;

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
                '}';
    }
}
