package com.hengtaierp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName(value = "system_menu")
public class SystemMenu implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long pid;

    private String title;

    private String icon;

    private String href;

    private String target;

    private List<SystemMenu> child;
}