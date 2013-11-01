package com.peng.security;

import java.util.Set;

import com.peng.model.Role;

public interface LoginRequired {
	
	public void setRequiredRoles(Set<String> roles);
	public Set<String> getRequiredRoles();
}
