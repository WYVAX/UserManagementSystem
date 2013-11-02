package com.peng.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	private  Set<Address> address = new HashSet<Address>();
	private String firstName;
	private String middleName;
	private String lastName;
	private String password;
	private String email;
	private String username;
	private Set<Role> roles = new HashSet<Role>();
	private Set<CreditCard> cards = new HashSet<CreditCard>();
	
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	public Set<CreditCard> getCards() {
		return cards;
	}

	public void setCards(Set<CreditCard> cards) {
		this.cards = cards;
	}

	@Id
	public String getUsername() {
		return username;
	}

	@ManyToMany(mappedBy="users", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role r){
		this.roles.add(r);
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



	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addAddress(Address a){
		this.getAddress().add(a);
		a.setUser(this);
	}
	
	@Override
	public String toString(){
		return "User name: " + firstName + " " + 
				(middleName==null? "": middleName) + " " + lastName + " ,  username: " + username;
	}
	
	public String fullName(){
		return firstName + " " + 
				(middleName==null? "": middleName) + " " + lastName ;
	}
	
	public boolean hasRole(String role){
		for(Role r : this.roles ){
			if(r.getRoleName().equals(role))
				return true;
		}
		return false;
	}
	
	public boolean amIadmin() {
		if(hasRole("ADMIN"))
			return true;
		else return false;
	}

}
