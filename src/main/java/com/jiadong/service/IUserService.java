package com.jiadong.service;

import com.jiadong.bean.User;

public interface IUserService {

    User checkUser(String username, String password);
}
