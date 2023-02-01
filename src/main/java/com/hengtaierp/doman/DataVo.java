package com.hengtaierp.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataVo<T> {
    private int code;
    private String message;
    private T data;

    //验证通过
    public void ok() {
        this.setCode(0);
    }
    //验证失败
    public void error() {
        this.setCode(1);
    }
    //账户停用
    public void deactivate(){
        this.setCode(2);
    }



}
