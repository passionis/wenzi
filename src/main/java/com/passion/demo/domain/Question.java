package com.passion.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * question表用于存储用户上传的提问数据
 * @author passion
 */
@Data
@TableName("question")
public class Question {
    /**
     * 主键
     */
    @TableId(value = "id",type =IdType.AUTO)
    private Integer id;

    /**
     * 问题的标题
     */
    private String title;

    /**
     * 问题描述
     */
    private String description;

    /**
     * 问题的创建人 GitHub的id
     */
    private int creator;

    /**
     * 评论数量
     */
    private int commentCount;

    /**
     * 查看人数
     */
    private int viewCount;


    /**
     * 点赞人数
     */
    private int likeCount;


    /**
     * 问题类型
     */
    private String tag;

    /**
     * 创建时间
     */
    private Long gmtCreate;


    /**
     * 修改时间
     */
    private Long gmtModified;


}
