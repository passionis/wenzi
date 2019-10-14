package com.passion.demo.controller;

import com.passion.demo.dto.GitHubDto;
import com.passion.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/callback")
    public String loginCallback(@RequestParam("code") String code, @RequestParam("state") int state, HttpServletResponse response) {

        String accessToken = loginService.getAccessToken(code);
        GitHubDto dto = loginService.getGitHubDto(accessToken);
        if (dto != null) {//GitHub登陆成功签发session cookie
            String token = loginService.insertOrUpdateUser(dto);
            response.addCookie(new Cookie("token", token));
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }



}
