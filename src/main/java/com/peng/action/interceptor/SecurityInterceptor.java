package com.peng.action.interceptor;

import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.peng.model.Role;
import com.peng.model.User;
import com.peng.action.security.LoginRequired;

public class SecurityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object action = invocation.getAction();
		
		System.out.println("########  security interceptor is called ##############");
		if (action instanceof LoginRequired) {
			if (!session.isEmpty()) {
				User user = (User) session.get("user");
				if (user != null) {
					
					Set<Role> roles = user.getRoles();
					Set<String> required = ((LoginRequired) action)
							.getRequiredRoles();
					
					for(Role r : roles){
						System.out.println(" ****************  user not null, roles: "+ r.getRoleName());
					}		

					if(hasRole(roles, required))
						return invocation.invoke();
					else return "securityerror";
						
				}
				else return "securityerror";
			}
			else return "securityerror";
		}
		return invocation.invoke();
	}
	
	private boolean hasRole(Set<Role> roles, Set<String> required){
		for (String r : required) {
			for(Role ro : roles){
			if (ro.getRoleName().equals(r))
				return true;
			}
		}
		return false;
	}

}
