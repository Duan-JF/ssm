package cn.duan.dao;

import cn.duan.domain.User;

import java.util.List;

public interface UserDao {
    List<User> queryAll();
    int insertUser(User user);
    User findUser(String name);
}
