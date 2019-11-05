package com.passion.demo.controller;

import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.passion.demo.domain.User;
import com.passion.demo.dto.QuestionDto;
import com.passion.demo.mapper.UserMapper;
import com.passion.demo.service.PublishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author passion
 */
@Controller
public class HomeController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PublishServiceImpl publishService;

    @GetMapping("/main")
    public String home() {

        return "main.html";
    }

    @ResponseBody
    @GetMapping("/getquestions")
    public String getquestions(HttpServletRequest request, Model model,
                       @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {
        Page<QuestionDto> dtoPage = new Page<>(page, size);
        dtoPage.setOrders(OrderItem.descs("gmt_create"));

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
        Page<QuestionDto> list = publishService.getQuestion(dtoPage);
        model.addAttribute("questions", list);
        Log.get(this.getClass()).error(JSON.toJSONString(list));

        return "index";
    }

}
