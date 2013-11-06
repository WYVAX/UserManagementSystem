package com.peng.action.security;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.util.CreateIfNull;
import com.opensymphony.xwork2.util.Element;
import com.opensymphony.xwork2.util.KeyProperty;
import com.opensymphony.xwork2.util.logging.Logger;
import com.peng.model.Address;
import com.peng.model.User;
import com.peng.action.security.utils.LoginRequired;
import com.peng.action.security.utils.RequiredRoles;
import com.peng.service.UserService;

@Conversion
@Results(value = {
		@Result(name = "input", location = "/registration/login.jsp"),
		@Result(name = "success", location = "/home.jsp"),
		@Result(name = "securityerror", location = "/securityerror.jsp"),
		@Result(name = "error", location = "/error.jsp") })
public class UserAction extends ActionSupport implements SessionAware,
		ParameterAware, Preparable, LoginRequired {

	private UserService userService;
	private RequiredRoles requiredRoles;
	private User editUser;
	private Set allUsers;
	private User updateUser;
	private Address addr;
	private User session_user;

	@KeyProperty(value = "id")
	@Element(value = com.peng.model.Address.class)
	@CreateIfNull(true)
	private Set<Address> addresses;

	public Set<Address> getAddresses() {
		return addresses;
	}

	public User getSession_user() {
		return session_user;
	}

	public void setSession_user(User session_user) {
		this.session_user = session_user;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Action(value = "deleteUser")
	@Override
	public String execute() {
		System.out.println("show the params : " + params.get("user_id"));

		if (userService.delete(params.get("user_id")[0]))
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
		String user_id = params.get("user_id")[0];

		this.editUser = userService.get(user_id);
		getSession().put("editUser", getEditUser());
		System.out.println(user_id + "'s address are: ");
		for (Address ad : ((User) session.get("editUser")).getAddress()) {
			System.out.println(ad.getId());
		}
		return SUCCESS;
	}

	@Action(value = "updateUser", results = { @Result(name = "success", location = "/user/updateSuccess.jsp") })
	public String update() {

		try {
			/*
			 * User user = (User) session.get("editUser");
			 *//* user.setAddress(addresses); */
			userService.update(editUser);
			if (addresses != null)
				for (Address a : addresses) {
					System.out.println(" address: " + a);
				}
			session.remove("editUser");
		} catch (SQLException e) {

			e.printStackTrace();
			return "update_fail";
		}
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
	private Map<String, String[]> params;

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

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.params = parameters;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

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

	@Override
	public void prepare() throws Exception {
		if (session != null && session.get("editUser") != null) {
			this.addresses = ((User) session.get("editUser")).getAddress();
			this.editUser = ((User) session.get("editUser"));
		}

		String id = (String) session.get("session_user");
		if (id != null) {
			this.session_user = userService.get(id);
		}

	}

}
