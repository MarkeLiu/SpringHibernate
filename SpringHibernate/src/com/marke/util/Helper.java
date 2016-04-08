package com.marke.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 *<label>Class describle:Helper.java</label>
 *项目名：SpringHibernate
 *包：com.marke.util 
 *创建时间：2016年3月28日
 *创建人：Mark
 */
public class Helper {

	private static Logger log = Logger.getLogger(Helper.class);
	
	
	/**
	 * 
	 * <label>deacrible:获取响应流</label>
	 *
	 * @param response
	 *            response
	 * @param request
	 *            request
	 * @return 作者：Mark 创建时间：2016年3月28日 修改描述： 修改人： 修改日期：
	 */
	public static PrintWriter getPrintWriter(HttpServletResponse response,HttpServletRequest request)
	{
		
		PrintWriter print = null;
		try {
			request.setCharacterEncoding("utg8");
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			print = response.getWriter();
		} catch (UnsupportedEncodingException e) {
			log.warn(e.toString());
			return null;
		} catch (IOException e) {
			log.warn(e.toString());
			return null;
		}
		return print;
	}
	
	/**
	  * 
	  *<label>deacrible:字符串参数检查</label>
	  *@param strs
	  *@return
	  *作者：Mark
	  *创建时间：2016年3月28日
	  *修改描述：
	  *修改人：
	  *修改日期：
	  */
	public static boolean paramCheck(String... strs)
	{
		for (String str : strs)
		{
			if (str == null || "".equals(str))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	  * 
	  *<label>deacrible:对象参数检查</label>
	  *@param objects
	  *@return
	  *作者：Mark
	  *创建时间：2016年3月28日
	  *修改描述：
	  *修改人：
	  *修改日期：
	  */
	public static boolean paramCheck(Object...objects )
	{
		for (Object obj : objects)
		{
			if (obj == null)
			{
				return false;
			}
		}
		return true;
	}
}
