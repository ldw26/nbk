package com.sbm.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@ApiModel(value = "邮件发送类",description = "用户记录邮件的发送者、接收者以及内容")
@Data
public class MailBean implements Serializable {

    @ApiModelProperty(value = "邮件接收人",name = "recipient",dataType = "String",required = true,example = "540106935@qq.com")
    private String recipient;

    @ApiModelProperty(value = "邮件主题",name = "subject",dataType = "String",required = true,example = "注册主题")
    private String subject;

    @ApiModelProperty(value = "邮件内容",name = "password",dataType = "String",required = true,example = "123456")
    private String content;

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MailBean{" +
                "recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
