package com.peng.action.security.utils;

import java.util.Set;

import com.peng.model.Role;

public interface LoginRequired {
	
	public void setRequiredRoles(RequiredRoles roles);
	public RequiredRoles getRequiredRoles();
}
