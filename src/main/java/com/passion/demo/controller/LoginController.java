package com.passion.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.passion.demo.domain.User;
import com.passion.demo.dto.GitHubDto;
import com.passion.demo.mapper.UserMapper;
import com.passion.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author passion
 */
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.selectByToken(token);
                    //已经登录
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                        return "redirect:/main";
                    }
                    break;
                }
            }
        }
        return "login-2";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes) {
        if (StrUtil.isEmpty(username)) {
            redirectAttributes.addFlashAttribute("error", "用户名为空");
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("username", username);
        if (StrUtil.isEmpty(password)) {
            redirectAttributes.addFlashAttribute("error", "密码为空");
            return "redirect:/";
        }

        User user = loginService.login(username,password);
        if (user != null) {
            return "redirect:/main";
        } else {
            redirectAttributes.addFlashAttribute("error", "用户不存在");
            return "redirect:/";
        }
    }



    @GetMapping("/callback")
    public String loginCallback(@RequestParam("code") String code, @RequestParam("state") int state, HttpServletResponse response) {

        String accessToken = loginService.getAccessToken(code);
        GitHubDto dto = loginService.getGitHubDto(accessToken);
        if (dto != null) {
            //GitHub登陆成功签发session cookie
            String token = loginService.insertOrUpdateUser(dto);
            response.addCookie(new Cookie("token", token));
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

}
