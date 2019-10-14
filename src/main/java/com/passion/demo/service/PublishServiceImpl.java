package com.passion.demo.service;

import com.passion.demo.domain.Question;
import com.passion.demo.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class PublishServiceImpl implements IPublishService {
    @Autowired
    QuestionMapper questionMapper;


    @Override
    public int insertQuestion(Question question) {
        return  questionMapper.insert(question);
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
}
