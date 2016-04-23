package com.marke.action.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.marke.entity.User;
import com.marke.service.user.UserService;
import com.marke.util.Helper;

/**
 */
@ParentPackage("basePackage")
@Namespace("/user")
@Action("userAction")
@Results({
	@Result(name="login",location="/pages/index.jsp")
	
})
public class UserAction {
	Logger log = Logger.getLogger(UserAction.class);
	@Autowired
	private UserService userService;
	
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
	public String login()
	{
		log.info("请求首页");
		return "login";
	}
	
	/**
	 * 用户注册
	  *<label>deacrible:this is method</label>
	  *@param request request
	  *@param response response
	  *作者：Mark
	  *创建时间：2016年4月23日
	  *修改描述：
	  *修改人：
	  *修改日期：
	 */
	public void addUser()
	{
		HttpServletRequest request  = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter printWriter;
		boolean flag = false;
		try {
			printWriter = response.getWriter();
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		User user = new User();
		if (!Helper.paramCheck(userName,passWord))
		{
			printWriter.print(flag);
			return;
			
		}
		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setUserId(UUID.randomUUID().toString());
		user.setCreateDate(new Date());
		try {
			
			flag = userService.addUser(user);
			printWriter.print(flag);
		} catch (DataIntegrityViolationException e) {
			log.error(e.toString());
			printWriter.print(false);
			return;
		}
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
	
}
