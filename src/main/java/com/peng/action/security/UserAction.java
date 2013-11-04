package com.peng.action.security;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.DefaultInterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.logging.Logger;
import com.peng.model.User;
import com.peng.action.security.utils.LoginRequired;
import com.peng.action.security.utils.RequiredRoles;
import com.peng.service.UserService;

@Results(value = {
		@Result(name = "input", location = "/registration/login.jsp"),
		@Result(name = "success", location = "/home.jsp"),
		@Result(name = "securityerror", location = "/securityerror.jsp"),
		@Result(name = "error", location = "/error.jsp") })
public class UserAction extends ActionSupport implements SessionAware,
		LoginRequired {

	private UserService userService;
	private RequiredRoles requiredRoles;
	private User editUser;
	private Set allUsers;
	private User updateUser;

	public User getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}

	public Set getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(Set allUsers) {
		this.allUsers = allUsers;
	}

	public User getEditUser() {
		return editUser;
	}

	public void setEditUser(User editUser) {
		this.editUser = editUser;
	}

	@Action(value = "deleteUser")
	@Override
	public String execute() {

		System.out.println("************************  required roles: "
				+ requiredRoles + " session is: " + this.getSession());
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (userService.delete((User) session.get("user")))
			return "success";
		else
			return "error";
	}

	@Action(value = "userList", results = { @Result(name = "success", location = "/admin/userList.jsp") })
	public String userList() {
		allUsers = userService.getAll();
		return SUCCESS;
	}

	@Action(value = "editUser", results = { @Result(name = "success", location = "/user/edit.jsp") })
	public String edit() {
		String user_id = ServletActionContext.getRequest().getParameter(
				"user_id");

		this.editUser = userService.get(user_id);
		System.out.println(user_id);
		return SUCCESS;
	}

	@Action(value = "updateUser", results = { @Result(name = "success", location = "/user/updateSuccess.jsp") })
	public String update() {
		System.out.println("&&&&&&&&&&&&" + updateUser);
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

	@Resource(name = "adminRequired")
	@Override
	public void setRequiredRoles(RequiredRoles roles) {
		this.requiredRoles = roles;
	}

	@Override
	public RequiredRoles getRequiredRoles() {
		return this.requiredRoles;
	}

}
