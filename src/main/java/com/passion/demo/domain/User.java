package com.passion.demo.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class User {

    @TableId(value = "id")
    private Integer id;

    private String accountId;

    private String name;

    private String token;

    private Long gmtCreate;

    private Long gmtModified;

    private String avatarUrl;


}
