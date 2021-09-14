package com.muskan.bean;

import java.util.List;

public class UserList {
	public List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public UserList(List<User> userList) {
		super();
		this.userList = userList;
	}
}
