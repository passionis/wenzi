package com.passion.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.passion.demo.domain.User;
import com.passion.demo.dto.GitHubDto;

public interface IGithubLogin extends IService<User> {

    /**
     * github oauth认证流程
     * GitHub 回调接口后重新请求GitHub地址 根据code 获取access_token
     *
     * @param code GET https://github.com/login/oauth/authorize 接口中返回的code
     * @return 返回github的当前用户的access_token
     */
    String getAccessToken(String code);

    /**
     * 网络请求 通过GitHub返回的access-token获取用户信息
     *
     * @param accessToken
     * @return 用户信息
     */
    GitHubDto getGitHubDto(String accessToken);

    /**
     * 插入登陆的用户
     *
     * @param dto GitHub登陆返回的对象
     * @return 插入数据的token
     */
    String insertOrUpdateUser(GitHubDto dto);
}
