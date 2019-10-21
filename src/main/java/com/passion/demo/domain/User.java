package com.passion.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户表
 *
 * @author passion
 */
@Data
@TableName(value = "user")
public class User {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * 用户的账户
     */
    private String accountId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * token
     */
    private String token;

    /**
     * 创建时间
     */
    private Long gmtCreate;

    /**
     * 修改时间
     */
    private Long gmtModified;


    /**
     * 头像地址
     */
    private String avatarUrl;


}
