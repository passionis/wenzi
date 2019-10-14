package com.passion.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("question")
public class Question {
    @TableId(value = "id",type =IdType.AUTO)
    private Integer id;

    private String title;

    private String description;

    private int creator;

    private int comment_count;

    private int view_count;


    private int like_count;
    private String tag;

    private Long gmt_create;
    private Long gmt_modified;


}
