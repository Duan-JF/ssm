package cn.duan.services;

import cn.duan.domain.User;

import java.util.List;

public interface UserServices {
    List<User> queryAll();
    int addUser(User user);
    boolean queryUser(String name);
}
