package com.peng.action.registration;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.peng.model.User;
import com.peng.service.UserService;


@Results(value = { @Result(name="input", location="/registration/login.jsp"), 
		@Result(name="success", location="/home.jsp" )
		})

public class LoginAction extends ActionSupport implements Preparable, SessionAware{
	
	@Action("login")
	@Override
	public String execute(){
			
		if(username!=null && password!=null){
			session_user = userService.get(username);
			if(session_user!=null && session_user.getPassword().equals(password)){
				session.put("session_user", session_user.getUsername());
				return SUCCESS;
			}
			else return "input";
		}
		else return "input";
	}
	
	@Action("logout")
	public String logout(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (!session.isEmpty()) {
			session.remove("session_user");
		}
		return "input";
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
	private User session_user;
	
	public User getSession_user() {
		return session_user;
	}

	public void setSession_user(User session_user) {
		this.session_user = session_user;
	}

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

	@Override
	public void prepare() throws Exception {
		String id = (String) session.get("session_user") ; 
		if(id != null){
			this.session_user = userService.get(id);
		}	

	}

	
}
