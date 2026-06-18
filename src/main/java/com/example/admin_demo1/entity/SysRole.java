package com.example.admin_demo1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("sys_role")
public class SysRole {
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("role_name")    // 数据库：role_name
    private String roleName;

    @TableField("role_code")    // 数据库：role_code
    private String roleCode;

    @TableField("description")  // 数据库：description
    private String description;

    @TableField("create_time")  // 数据库：create_time
    private LocalDateTime createTime;

    @TableField("update_time")  // 数据库：update_time
    private LocalDateTime updateTime;
}