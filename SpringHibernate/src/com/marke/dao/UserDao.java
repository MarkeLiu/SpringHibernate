package com.marke.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marke.entity.User;

@Repository("userDao")
public class UserDao {

	private Logger log = Logger.getLogger(UserDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addUser(User user)
	{
		
		boolean flag = false;
		try {
			Serializable s = this.sessionFactory.getCurrentSession().save(user);
			return s == null ? false:true;
		} catch (Exception e) {
			log.error(e.getMessage());
			return flag;
		}
	}
	
	public boolean updateUserByUserId(User user)
	{
		this.sessionFactory.getCurrentSession().update("user_id",user);
		return  false;
	}
	
	public boolean deleteUserByUserId(int userId)
	{
		this.sessionFactory.getCurrentSession().delete("user_id",userId);
		return false;
	}
	
	public User queryUserByUserId(int userId)
	{
		this.sessionFactory.getCurrentSession();
		return null;
	}
	
	public User queryUserByUserName(String userName)
	{
		return null;
		
	}
	
	public List<User> queryUser()
	{
		return null;
	}
}
