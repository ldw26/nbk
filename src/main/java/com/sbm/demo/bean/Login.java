package com.sbm.demo.bean;

public class Login {
    private Integer userId;
    public String logName;
    public String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userId=" + userId +
                ", logName='" + logName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
