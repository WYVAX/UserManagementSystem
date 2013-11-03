package com.peng.action.security;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peng.action.security.utils.LoginRequired;
import com.peng.action.security.utils.RequiredRoles;
import com.peng.model.User;


@Results(value = { @Result(name="success", location="/admin/dashboard.jsp") })
public class UpdateUserAction extends ActionSupport implements  
ModelDriven<User>, SessionAware{

	private RequiredRoles requiredRoles;
	private Map session;
	private User user = new User();
	
	@Action("updateUser")	
	@Override
	public String execute(){
		System.out.println("*******user is: " + user);
		return SUCCESS;
	}
/*	
	@Resource(name="userRequired")
	@Override
	public void setRequiredRoles(RequiredRoles roles) {
				this.requiredRoles=roles;
	}

	@Override
	public RequiredRoles getRequiredRoles() {
		return this.requiredRoles;
	}

*/	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;		
	}

	@Override
	public User getModel() {
		return this.user;
	}

}
