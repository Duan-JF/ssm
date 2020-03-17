package cn.duan.services.impl;

import cn.duan.dao.UserDao;
import cn.duan.domain.User;
import cn.duan.services.UserServices;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Component
public class UserServicesImpl implements UserServices {
    UserDao userDao;

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public boolean queryUser(String name) {
        User user = userDao.findUser(name);
        if (user != null)
            return true;
        else
            return false;
    }
}
