package com.passion.demo.controller;

import com.passion.demo.domain.Question;
import com.passion.demo.domain.User;
import com.passion.demo.mapper.UserMapper;
import com.passion.demo.service.PublishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    PublishServiceImpl publishService;

    @Autowired
    UserMapper userMapper;


    /**
     * 跳转到发起问题的页面
     *
     * @return
     */
    @GetMapping("/publish")
    public String publishView() {
        return "publish";
    }


    /**
     * 发起提问接口
     *
     * @return
     */
    @PostMapping("/publish")
    public String publisData(@RequestParam(value = "title", required = false) String title,
                             @RequestParam(value = "description", required = false) String description,
                             @RequestParam(value = "tag", required = false) String tag, HttpServletRequest request,
                             Model model) {
        User user = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.selectByToken(token);
                }
            }
        }
        if (user == null) {
            model.addAttribute("errorMessage", "用户未登陆");
            return "publish";
        }

        if (title == null || title.isEmpty()) {
            model.addAttribute("errorMessage", "请填写标题");
            return "publish";
        }

        if (description == null || description.isEmpty()) {
            model.addAttribute("errorMessage", "请求填写问题补充");
            return "publish";
        }

        if (tag == null || tag.isEmpty()) {
            model.addAttribute("errorMessage", "请选择标签");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(System.currentTimeMillis());
        question.setCommentCount(0);
        question.setLikeCount(0);
        question.setViewCount(0);
        question.setCreator(user.getId());

        publishService.insertQuestion(question);
        return "publish";
    }
}
