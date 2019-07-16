package com.sbm.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户登陆类",description = "用于对用户登陆信息的核对")
public class Login {

    @ApiModelProperty(value = "用户Id",name = "userId",dataType = "Integer",example = "1")
    private Integer userId;

    @ApiModelProperty(value = "用户名",name = "logName",dataType = "String",required = true,example = "xiaogang123")
    public String logName;

    @ApiModelProperty(value = "用户密码",name = "password",dataType = "String",required = true,example = "123456")
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
