package com.peng.action.registration;


import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peng.model.Address;
import com.peng.model.Role;
import com.peng.model.User;
import com.peng.service.UserService;

@Results(value = { @Result(name = "fail", location= "/registration/registrationFail.jsp"),
		@Result(name = "success", location = "/registration/registrationSuccess.jsp"),
		@Result(name = "input", location = "/registration/registration.jsp") })
public class RegProcessMDAction 
	extends ActionSupport implements ModelDriven<Address>, SessionAware {


	@Action("regProcessMD")
	@Override
	public String execute() {
			User user = addr.getUser();
			Role role = new Role();
			role.setRoleName("USER");
			role.addUser(user);
			user.addRole(role);
			userService.add(user);
			return SUCCESS;
	}


	private UserService userService;
	private String password2;
	
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public UserService getUserService() {
		return userService;
	}


	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	Address addr = new Address();
	
	@Override
	public Address getModel() {
		User u = new User();
		addr.setUser(u);
		u.addAddress(addr);
		return addr;
	}

	@Override
	public void validate(){
		if(!addr.getUser().getPassword().equals(getPassword2())){
			addFieldError(password2, "passwords are not match");
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}
}
