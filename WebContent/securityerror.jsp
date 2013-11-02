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
<title>Registration Success</title>
</head>
<body>
User is not authenticated/login or access denied! Please login: 
<br> 
<a href='<s:url action="login" namespace="/registration" /> ' >Login Page</a>

<div>
Or back to user home: 
<s:if test='%{#session.user.roles.isEmpty()}'>
<a href='<s:url action="userHome" namespace="/registration"/>'>UserHome</a>

</s:if>
<s:else>
<a href='<s:url action="login" namespace="/registration"/>'>Login</a>
</s:else>

</div>


<s:debug></s:debug>
</body>
</html>