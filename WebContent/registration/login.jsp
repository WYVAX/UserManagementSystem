<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String path = request.getContextPath(); 
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
	path + "/"; %>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<s:form action="login">
		<s:textfield name="username" label="input user name"/>
		<s:password name="password" label="input password"/>
		<s:submit></s:submit>
	</s:form>
<br>
Or register
<a href='<s:url action="regPageMD" namespace="/registration"/>'><font color="red">HERE</font></a>

<s:debug/>
</body>
</html>