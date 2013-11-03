package com.peng.action.security.utils;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component("userRequired")
public class UserRequired implements RequiredRoles {
	private static Set<String> requiredRoles ;
	
	static{
		UserRequired.requiredRoles = new HashSet<String>();
		UserRequired.requiredRoles.add("USER");
	}
	
	@Override
	public void setRequiredRoles(Set<String> roles) {
		UserRequired.requiredRoles = roles;
	}

	@Override
	public Set<String> getRequiredRoles() {
		return UserRequired.requiredRoles;
	}

}
