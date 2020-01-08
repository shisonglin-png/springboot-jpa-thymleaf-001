package com.offcn.Impl;

import com.offcn.UserService;
import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserSrviceImpl  implements UserService {
    @Autowired
    UserDao ud;
    @Override
    public void add(User user) {
        ud.save(user);
    }

    @Override
    public void update(User user) {
        ud.saveAndFlush(user);
    }

    @Override
    public void delete(Long id) {
        ud.deleteById(id);
    }

    @Override
    public User findOne(Long id) {

        return ud.findById(id).get();
    }

    @Override
    public List<User> findAll() {

        return ud.findAll();
    }
}
