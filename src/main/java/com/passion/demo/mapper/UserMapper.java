package com.passion.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.passion.demo.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {


    /**
     * 根据token查询用户
     * @param token token
     * @return 用户对象
     */
    User selectByToken(String token);


    /**
     * 根据用户名密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return user对象
     */
    User selectByUserName(@Param("username") String username, @Param("password") String password);

}
