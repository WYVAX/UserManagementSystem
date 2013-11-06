package com.peng.action.security;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.NonUniqueObjectException;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.peng.model.Address;
import com.peng.model.User;
import com.peng.action.security.utils.LoginRequired;
import com.peng.action.security.utils.RequiredRoles;
import com.peng.service.AddressService;
import com.peng.service.UserService;

@Results(value = {
		@Result(name = "logout", location = "/registration/login.jsp"),
		@Result(name = "success", location = "/user/address.jsp"),
		@Result(name = "securityerror", location = "/securityerror.jsp") })
public class AddressAction extends ActionSupport implements SessionAware,
		ParameterAware, LoginRequired {

	private RequiredRoles requiredRoles;
	private Map<String, String[]> params;
	private Address newAddress;
	private AddressService addressService;
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private String user_id;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Action(value = "addresses")
	@Override
	public String execute() {
		System.out.println("************************  required roles: "
				+ requiredRoles);
		return "success";
	}

	public Address getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(Address newAddress) {
		this.newAddress = newAddress;
	}

	@Action(value = "address", results = {
			@Result(name = "success", location = "/user/addAddress.jsp"),
			@Result(name = "fail", location = "/error.jsp") })
	public String address() {
		if (params != null) {
			String[] arr = params.get("address_id");
			String[] ui = params.get("user_id");

			if (ui != null)
				this.user_id = ui[0];

			System.out.println("################## param.address_id is: " + arr
					+ " user_id is: " + user_id);
			if (arr != null && arr.length > 0) {
				String id = arr[0];
				this.newAddress = addressService.get(Integer.parseInt(id));
			}

		}
		return "success";

	}

	@Action(value = "addAddress", results = {
			@Result(name = "success", location = "/user/addAddress_success.jsp"),
			@Result(name = "fail", location = "/error.jsp") })
	public String addAddress() throws Exception {
		User user = userService.get(user_id);
		newAddress.setUser(user);
		try {

			addressService.update(newAddress);
			return "success";
		} catch (NonUniqueObjectException e) {
			e.printStackTrace();
			addressService.updateCRUD(newAddress);
			return "success";
		}
		catch(SQLException e){
			e.printStackTrace();
			return "fail";
		}
	}

	private Map session;

	public Map getSession() {
		return session;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	@Resource(name = "addressService")
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	@Override
	public void setSession(Map session) {
		this.session = session;
	}

	@Resource(name = "userRequired")
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

}
