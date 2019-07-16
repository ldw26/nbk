package com.sbm.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "返回数据的类",description = "用户记录请求是否成功以及返回的具体数据")
public class Result<T> {

    @ApiModelProperty(value = "请求是否成功",name = "flag",dataType = "Boolean",required = true,example = "true")
    private Boolean flag;

    @ApiModelProperty(value = "返回客户端的数据,使用泛型T代替",name = "data",dataType = "T",example = "UserInfo")
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Result{" +
                "flag=" + flag +
                ", data=" + data +
                '}';
    }
}
