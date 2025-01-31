package com.oa.service;

import com.oa.entity.User;
import com.oa.mapper.UserMapper;
import com.oa.service.exception.LoginException;
import com.oa.utils.Md5Utils;

public class UserService {
    private UserMapper userMapper = new UserMapper();
    /**
     * 根据前台输入进行登录校验
     * @param username 前台输入的用户名
     * @param password 前台输入的密码
     * @return 校验通过后,包含对应用户数据的User实体类
     * @throws LoginException 用户登录异常
     */
    public User checkLogin(String username , String password){
        User user = userMapper.selectByUsername(username);
        if(user == null){
            throw new LoginException("用户名不存在");
        }
        String md5 = Md5Utils.md5Digest(password, user.getSalt());
        if(!md5.equals(user.getPassword())){
            throw new LoginException("密码错误");
        }
        return user;
    }
}
