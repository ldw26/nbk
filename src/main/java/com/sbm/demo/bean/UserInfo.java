package com.sbm.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户详细信息类", description = "用户记录用户的详细信息")
public class UserInfo {

    @ApiModelProperty(value = "用户Id", name = "userId", dataType = "Integer", required = true, example = "1")
    private Integer userId;

    @ApiModelProperty(value = "用户邮箱", name = "email", dataType = "String", example = "540106935@qq.com")
    private String email;

    @ApiModelProperty(value = "用户注册日期", name = "registerDate", dataType = "String", example = "20190714")
    private String registerDate;

    @ApiModelProperty(value = "用户存款数", name = "deposit", dataType = "String", example = "714")
    private String deposit;

    @ApiModelProperty(value = "用户性别", name = "sex", dataType = "String", example = "male")
    private String sex;

    @ApiModelProperty(value = "用户住址", name = "address", dataType = "String", example = "杭州")
    private String address;

    @ApiModelProperty(value = "用户电话号码", name = "phoneNumber", dataType = "String", example = "1568897541")
    private String phoneNumber;

    @ApiModelProperty(value = "用户名", name = "userName", dataType = "String", required = true, example = "xiaogang123")
    private String userName;

    @ApiModelProperty(value = "用户职业", name = "profession", dataType = "String", example = "医生")
    private String profession;

    @ApiModelProperty(value = "用户密码", name = "password", dataType = "String", required = true, example = "123456")
    private String password;

    @ApiModelProperty(value = "用户身份证", name = "idCard", dataType = "String", example = "330495784454165")
    private String idCard;

    @ApiModelProperty(value = "用户真实姓名", name = "name", dataType = "String", example = "李刚")
    private String name;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", deposit='" + deposit + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", profession='" + profession + '\'' +
                ", password='" + password + '\'' +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
