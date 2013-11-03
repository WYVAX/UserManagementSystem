package com.peng.action.security.utils;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component("adminRequired")
public class AdminRequired implements RequiredRoles {
	private static Set<String> requiredRoles ;
	
	static{
		AdminRequired.requiredRoles = new HashSet<String>();
		AdminRequired.requiredRoles.add("ADMIN");
	}
	
	@Override
	public void setRequiredRoles(Set<String> roles) {
		AdminRequired.requiredRoles = roles;
	}

	@Override
	public Set<String> getRequiredRoles() {
		return AdminRequired.requiredRoles;
	}

}
