package com.peng.action.security;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.peng.model.User;
import com.peng.action.security.utils.LoginRequired;
import com.peng.action.security.utils.RequiredRoles;
import com.peng.service.UserService;

@Results(value = {
		@Result(name = "logout", location = "/registration/login.jsp"),
		@Result(name = "success", location = "/admin/dashboard.jsp"),
		@Result(name = "securityerror", location = "/securityerror.jsp") })
public class AdminAction extends ActionSupport implements SessionAware,
		Preparable, LoginRequired {

	private UserService userService;
	private RequiredRoles requiredRoles;
	private User session_user;
	
	public User getSession_user() {
		return session_user;
	}

	public void setSession_user(User session_user) {
		this.session_user = session_user;
	}

	@Action(value = "adminDashboard")
	@Override
	public String execute() {
		System.out.println("************************  required roles: "
				+ requiredRoles);
		return "success";
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

	@Resource(name="adminRequired")
	@Override
	public void setRequiredRoles(RequiredRoles roles) {
		this.requiredRoles = roles;		
	}

	@Override
	public RequiredRoles getRequiredRoles() {
		return this.requiredRoles;
	}

	@Override
	public void prepare() throws Exception {
		String id = (String) session.get("session_user") ; 
		if(id != null){
			this.session_user = userService.get(id);
		}	
	}

}
