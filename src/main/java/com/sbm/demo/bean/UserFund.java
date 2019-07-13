package com.sbm.demo.bean;

import java.util.Map;

public class UserFund {
    private Integer userId;
    private Integer fundId;
    private String buyTime;
    private String FundMoney;
    private Map<String,String> HashMap;

    public String getFundMoney() {
        return FundMoney;
    }

    public void setFundMoney(String fundMoney) {
        FundMoney = fundMoney;
    }

    public Map<String, String> getHashMap() {
        return HashMap;
    }

    public void setHashMap(Map<String, String> hashMap) {
        HashMap = hashMap;
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
                '}';
    }
}
