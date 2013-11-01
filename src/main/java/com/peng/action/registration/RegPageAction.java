package com.peng.action.registration;



import org.apache.struts2.config.Result;

import com.opensymphony.xwork2.ActionSupport;

@Result(name="success", value="/reg/registration.jsp" )
public class RegPageAction extends ActionSupport{
	
	@Override
	public String execute(){
		return SUCCESS;
	}
}
