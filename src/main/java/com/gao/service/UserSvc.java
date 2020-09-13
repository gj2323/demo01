package com.gao.service;

import com.gao.entity.User;

public interface UserSvc {
    public User queryUser(String username);
    public  void  modifyUser(User user);
}
