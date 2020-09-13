package com.gao.service;

import com.gao.entity.User;
import com.gao.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
@Transactional
public class UserSvcImpl implements UserSvc {
    @Resource
    private UserMapper userMapper;

    @Override
    public User queryUser(String username) {
        return userMapper.selectUser(username);
    }

    @Override
    public void modifyUser(User user) {
        userMapper.updateUser(user);
    }
}
