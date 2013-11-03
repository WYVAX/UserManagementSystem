package com.peng.action.security.utils;

import java.util.Set;

public interface RequiredRoles {
	public void setRequiredRoles(Set<String> roles);
	public Set<String> getRequiredRoles();
}
