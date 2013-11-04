<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Home page</title>
</head>
<body>

		<s:form action="updateUser" namespace="/security" >
			<s:textfield name="updateUser.username" value="%{editUser.username}" label="username" key="username"/>
			<s:textfield name="updateUser.firstName" value="%{editUser.firstName}" label="firstName" />
			<s:textfield name="updateUser.middleName" value="%{editUser.middleName}" label="middleName" />
			<s:textfield name="updateUser.lastName" value="%{editUser.lastName}" label="lastName" />
			<s:textfield name="updateUser.email" value="%{editUser.email}" label="email"/>
			<s:textfield name="updateUser.password" value="%{editUser.password}" label="password"/>

 
 			<s:submit></s:submit>
		</s:form>

	
	<s:debug></s:debug>
</body>
</html>