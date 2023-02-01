package com.hengtaierp.doman;

import com.hengtaierp.entity.SystemMenu;
import lombok.Data;

import java.util.List;

@Data
public class MenuVo {
    private Integer code;
    private String message;


    private List<SystemMenu> menuInfo;

    private HomeVo homeInfo;

    private LogoVo logoInfo;

}
