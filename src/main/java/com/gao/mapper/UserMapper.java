package com.gao.mapper;

import com.gao.entity.User;

public interface UserMapper {
   public User selectUser(String username);
   public  void  updateUser(User user);

}
