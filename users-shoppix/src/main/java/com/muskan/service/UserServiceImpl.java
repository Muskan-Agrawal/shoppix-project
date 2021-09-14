package com.muskan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muskan.bean.User;
import com.muskan.bean.UserList;
import com.muskan.persistence.UserDao;

@Service
public class UserServiceImpl implements UserService{
	private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserList getAllUsers() {
    	List<User> userList = new ArrayList<User>();
    	userList = userDao.findAll();
        return new UserList(userList);
    }

    @Override
    public User insertUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getById(id);
    }

    @Override
    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public User deleteUserById(int id) {
        User user = userDao.getById(id);
        userDao.deleteById(id);
        return user;
    }

    @Override
    public User updateUserName(int id, String name) {
        int rows = userDao.updateUserName(id, name);
        if (rows > 0) return userDao.getById(id);
        return null;
    }

    @Override
    public User updateUserPassword(int id, String password) {
        int rows = userDao.updateUserPassword(id, password);
        if (rows > 0) return userDao.getById(id);
        return null;
    }
}
