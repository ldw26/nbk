package com.sbm.demo.bean;

public class UserFund {
    private Integer userId;
    private Integer fundId;
    private String buyTime;

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
