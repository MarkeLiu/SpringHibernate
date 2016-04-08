package com.marke.service.user;

import java.util.List;

import com.marke.entity.User;

public interface UserService {

	boolean addUser(User user);
	boolean updateUserByUserId(User user);
	boolean deleteUserByUserId(int userId);
	User queryUserByUserId(int userId);
	User queryUserByUserName(String userName);
	List<User> queryUser();
}
