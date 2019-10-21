package com.passion.demo.controller;

import com.passion.demo.domain.User;
import com.passion.demo.dto.QuestionDto;
import com.passion.demo.mapper.UserMapper;
import com.passion.demo.service.PublishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PublishServiceImpl publishService;



    @GetMapping("/")
    public String test(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.selectByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        List<QuestionDto> list = publishService.getQuestion();
        model.addAttribute("questions",list);
        return "index";
    }
}
