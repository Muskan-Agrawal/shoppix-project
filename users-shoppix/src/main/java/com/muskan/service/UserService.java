package com.muskan.service;

import org.springframework.stereotype.Service;

import com.muskan.bean.User;
import com.muskan.bean.UserList;

@Service
public interface UserService {
	UserList getAllUsers();
    User insertUser(User user);
    User getUserById(int id);
    User getUserByName(String userName);
    User deleteUserById(int id);
    User updateUserName(int id, String name);
    User updateUserPassword(int id, String password);
}
