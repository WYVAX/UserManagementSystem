package com.peng.action.interceptor;

import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.peng.model.Role;
import com.peng.model.User;
import com.peng.security.LoginRequired;

public class SecurityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object action = invocation.getAction();
		System.out.println(" ****************  my interceptor ");
		return "securityerror";
/*		if (action instanceof LoginRequired) {
			if (!session.isEmpty()) {
				User user = (User) session.get("user");
				if (user != null) {
					Set<Role> roles = user.getRoles();
					Set<String> required = ((LoginRequired) action)
							.getRequiredRoles();
					for (String r : required) {
						if (!roles.contains(r))
							return "securityerror";
					}
				}
				else return "securityerror";
			}
			else return "securityerror";
		}
		return invocation.invoke();
*/	}

}
