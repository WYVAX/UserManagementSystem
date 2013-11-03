package com.peng.action.registration;




import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Result(name="success", location="/registration/registration.jsp" )
public class RegPageAction extends ActionSupport{
	
	@Action("regPage")
	@Override
	public String execute(){
		return SUCCESS;
	}
	
	 @Action(value="regPageMD", results={@Result(name="success", location="/registration/registrationMD.jsp")})
	public String regPageMD(){
		return SUCCESS; 
	}
}
