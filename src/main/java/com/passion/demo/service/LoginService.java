package com.passion.demo.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.passion.demo.domain.User;
import com.passion.demo.dto.GitHubDto;
import com.passion.demo.dto.GithubRequestBody;
import com.passion.demo.mapper.UserMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class LoginService implements IGithubLogin {

    @Value("${github.client_id}")
    private String client_id;

    @Value("${github.client_secret}")
    private String client_secret;

    @Value("${github.redirect_uri}")
    private String redirect_uri;

    @Autowired
    private UserMapper userMapper;


    private String post(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public String getAccessToken(String code) {
        String post = "";
        try {
            String url = "https://github.com/login/oauth/access_token";
            GithubRequestBody githubRequestBody = new GithubRequestBody();
            githubRequestBody.setClient_id(client_id);
            githubRequestBody.setClient_secret(client_secret);
            githubRequestBody.setCode(code);
            githubRequestBody.setRedirect_uri(redirect_uri);
            String json = JSON.toJSONString(githubRequestBody);
            post = post(url, json);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public GitHubDto getGitHubDto(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?" + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            System.out.println(string);
            GitHubDto gitHubDto = JSON.parseObject(string, GitHubDto.class);
            return gitHubDto;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String insertOrUpdateUser(GitHubDto dto) {
        String token = UUID.randomUUID().toString();

        User entity = new User();
        entity.setId(dto.getId());
        entity.setAccountId(dto.getNode_id());
        entity.setName(dto.getLogin());
        entity.setToken(token);
        entity.setGmtCreate(System.currentTimeMillis());
        entity.setGmtModified(System.currentTimeMillis());

        User user = userMapper.selectById(dto.getId());
        if (user != null) {
            userMapper.update(entity, new UpdateWrapper<>());
        } else {
            userMapper.insert(entity);
        }
        return token;
    }
}
