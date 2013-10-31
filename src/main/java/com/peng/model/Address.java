package com.peng.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	private User user;

	@Id
	@ManyToOne
	@PrimaryKeyJoinColumn
	public User getUser() {
		return user;
	}
	
	
	public void setUser(User user) {
		this.user = user;
	}

	private int roomNumber;

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	private String streetAddr;
	private String streetAddr2;
	private String state;
	private String country;

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

}
