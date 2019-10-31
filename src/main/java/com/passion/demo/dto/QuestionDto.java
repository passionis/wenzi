package com.passion.demo.dto;

import com.passion.demo.domain.User;
import lombok.Data;

/**
 * 传递给前端的问题数据
 *
 * @author passion
 */
@Data
public class QuestionDto {
    private Integer id;

    private String title;

    private String description;

    private Long creator;

    private int commentCount;

    private int viewCount;

    private int likeCount;

    private String tag;

    private Long gmtCreate;

    private Long gmtModified;

    private String avatarUrl;

    private User user;

    private String lastTime;
}
