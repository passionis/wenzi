package com.passion.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.passion.demo.domain.Question;
import com.passion.demo.dto.QuestionDto;
import com.passion.demo.mapper.QuestionMapper;
import org.joda.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author passion
 */
@Service
public class PublishServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IPublishService {
    @Autowired
    QuestionMapper questionMapper;


    @Override
    public int insertQuestion(Question question) {
        return questionMapper.insert(question);
    }

    @Override
    public boolean hasLogin(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                }
            }
        }
        return false;
    }

    @Override
    public Page<QuestionDto> getQuestion(Page<QuestionDto> page) {
        List<QuestionDto> questions = questionMapper.getQuestion(page);
        if (questions != null) {
            questions.forEach(dto -> {
                Long gmtCreate = dto.getGmtCreate();
                Duration duration = new Duration(gmtCreate, System.currentTimeMillis());
                String str = "";
                long standardHours = duration.getStandardHours();
                if (standardHours > 24) {
                    long standardDays = duration.getStandardDays();
                    str = standardDays + "天";
                } else {
                    str = standardHours + "小时";
                }
                dto.setLastTime(str);
            });
        }
        return page.setRecords(questions);
    }


}
