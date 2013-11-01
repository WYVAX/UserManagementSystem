package com.peng.action.registration;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.config.Action;
import org.apache.struts2.config.Results;
import org.apache.struts2.config.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.peng.model.User;
import com.peng.security.LoginRequired;
import com.peng.service.UserService;

@Results(value = { @Result(name = "input", value = "/reg/login.jsp"),
		@Result(name = "success", value= "/home.jsp") })

public class DeleteUserAction extends ActionSupport implements SessionAware,
		LoginRequired {

	private UserService userService;
	private static Set<String> requiredRoles;

	static {
		requiredRoles = new HashSet<String>();
		requiredRoles.add("USER");
		requiredRoles.add("ADMIN");
	}

	
	//@Action(value = "action1", interceptorRefs = @InterceptorRef("security"))
	@Override
	public String execute() {
		System.out.println("************************  required roles: " + requiredRoles);
		return SUCCESS;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private Map session;

	public Map getSession() {
		return session;
	}

	@Override
	public void setSession(Map session) {
		this.session = session;
	}

	@Override
	public void setRequiredRoles(Set<String> roles) {
		this.requiredRoles = roles;
	}

	@Override
	public Set<String> getRequiredRoles() {
		return this.requiredRoles;
	}

}
