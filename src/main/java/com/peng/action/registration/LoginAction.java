package com.peng.action.registration;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.peng.model.User;
import com.peng.service.UserService;


@Results(value = { @Result(name="input", value="/reg/login.jsp"), 
		@Result(name="success", value="/home.jsp" )
		})

public class LoginAction extends ActionSupport implements SessionAware{
	
	@Override
	public String execute(){
	
		if(username!=null && password!=null){
			User u = userService.get(username);
			if(u!=null && u.getPassword().equals(password)){
				session.put("user", u);
				return SUCCESS;
			}
			else return "input";
		}
		else return "input";
	}
	
	
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	private String username;
	private String password;
	private Map session;
	
	public Map getSession() {
		return session;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void setSession(Map session) {
			this.session = session;
	}

	
}
