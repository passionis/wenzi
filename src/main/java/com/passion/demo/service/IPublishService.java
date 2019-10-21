package com.passion.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.passion.demo.domain.Question;
import com.passion.demo.dto.QuestionDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IPublishService extends IService<Question> {

    /**
     * 插入提问对象
     *
     * @param question
     * @return
     */
    int insertQuestion(Question question);

    /**
     * 根据请求中的session 判断当前提交是否登录过
     *
     * @param request 提问的请求
     * @return 是否login
     */
    boolean hasLogin(HttpServletRequest request);

    /**
     * 获取所有的提问数据
     * @return
     */
    List<QuestionDto> getQuestion();

}
