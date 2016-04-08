package com.marke.serviceImpl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marke.dao.UserDao;
import com.marke.entity.User;
import com.marke.service.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean addUser(User user) {

		return userDao.addUser(user);
	}

	@Override
	public boolean updateUserByUserId(User user) {

		return userDao.updateUserByUserId(user);
	}
	
	@Override
	public boolean deleteUserByUserId(int userId) {
		
		return userDao.deleteUserByUserId(userId);
	}

	@Override
	public User queryUserByUserId(int userId) {
		
		return userDao.queryUserByUserId(userId);
	}
	
	@Override
	public User queryUserByUserName(String userName) {
		
		return userDao.queryUserByUserName(userName);
	}
	
	@Override
	public List<User> queryUser() {
		
		return userDao.queryUser();
	}
}
