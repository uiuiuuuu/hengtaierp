package com.hengtaierp.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataVo<T>{
    private int code;
    private String message;
    private T data;

}
