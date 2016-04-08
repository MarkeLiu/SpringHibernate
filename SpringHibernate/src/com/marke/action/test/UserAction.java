package com.marke.action.test;

import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.marke.entity.User;
import com.marke.service.user.UserService;
import com.marke.util.Helper;

/**
 */
@ParentPackage("basePackage")
@Namespace("/user")
@Action("userAction")
@Results({
	@Result(name="test2",location="/pages/index.jsp")
	
})
public class UserAction {
	Logger log = Logger.getLogger(UserAction.class);
	@Autowired
	private UserService userService;

	public void test1() {
		User user = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setUserName("Marke");
		user.setPassWord("000000");
		user.setCreateDate(new Date());
		log.info(userService.addUser(user));
		log.info("come in");
	}

	
	/**
	  * 
	  *<label>deacrible:this is method</label>
	  *@return String
	  *作者：Mark
	  *创建时间：2016年3月28日
	  *修改描述：
	  *修改人：
	  *修改日期：
	  */
	public String test2()
	{
		log.info("请求首页");
		return "test2";
	}
	
	public boolean addUser(HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter print = Helper.getPrintWriter(response, request);
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		User user = new User();
		if (Helper.paramCheck(userName,passWord))
		{
			return false;
			
		}
		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setCreateDate(new Date());
		
		return userService.addUser(user);
		
	}
	
}
