package com.peng.action.registration;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.peng.model.Address;
import com.peng.model.User;
import com.peng.service.UserService;

@Results(value = { @Result(name = "fail", location= "/registration/registrationFail.jsp"),
		@Result(name = "success", location = "/registration/registrationSuccess.jsp"),
		@Result(name = "input", location = "/registration/registration.jsp") })
public class RegProcessAction extends ActionSupport {

	// private static ClassPathXmlApplicationContext ctx = new
	// ClassPathXmlApplicationContext("beans.xml");


	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Action("regProcess")
	@Override
	public String execute() {
		if (password.equals(password2)) {
			User user = new User();
			Address addr = new Address();
			addr.setCountry(country);
			addr.setRoomNumber(roomNumber);
			addr.setState(state);
			addr.setStreetAddr(streetAddr);
			addr.setStreetAddr2(streetAddr2);
			addr.setUser(user);
			user.addAddress(addr);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setMiddleName(middleName);
			user.setPassword(password);
			user.setEmail(email);
			user.setUsername(username);
			userService.add(user);
			return SUCCESS;
		} else
			return "fail";
	}

	private String firstName;
	private String middleName;
	private String lastName;
	private String password;
	private String password2;
	private int roomNumber;
	private String streetAddr;
	private String streetAddr2;
	private String state;
	private String country;
	private String email;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getStreetAddr() {
		return streetAddr;
	}

	public void setStreetAddr(String streetAddr) {
		this.streetAddr = streetAddr;
	}

	public String getStreetAddr2() {
		return streetAddr2;
	}

	public void setStreetAddr2(String streetAddr2) {
		this.streetAddr2 = streetAddr2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
