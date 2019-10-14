package com.passion.demo.service;

import com.passion.demo.domain.Question;

import javax.servlet.http.HttpServletRequest;

public interface IPublishService {
    /**
     * 插入提问对象
     * @param question
     * @return
     */
    int insertQuestion(Question question);

    /**
     * 根据请求中的session 判断当前提交是否登录过
     * @param request    提问的请求
     * @return           是否login
     */
    boolean hasLogin(HttpServletRequest request);
}
