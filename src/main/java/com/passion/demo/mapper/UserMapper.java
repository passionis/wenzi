package com.passion.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.passion.demo.domain.User;

public interface UserMapper extends BaseMapper<User> {


    /**
     * 根据token查询用户
     * @param token token
     * @return 用户对象
     */
    User selectByToken(String token);
}
