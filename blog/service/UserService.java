package com.jd.blog.service;

import com.jd.blog.po.User;

public interface UserService {
    User checkUser(String username,String password);

}
