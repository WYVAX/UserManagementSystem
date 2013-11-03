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
	<div>
		<s:form action="updateUser" namespace="/security" name="user">
			<s:textfield name="username" value="%{editUser.username}" label="username" />
			<s:textfield name="firstName" value="%{editUser.firstName}" label="firstName" />
			<s:textfield name="middleName" value="%{editUser.middleName}" label="middleName" />
			<s:textfield name="lastName" value="%{editUser.lastName}" label="lastName" />
			<s:textfield name="email" value="%{editUser.email}" label="email"/>
			<s:textfield name="password" value="%{editUser.password}" label="password"/>
			<s:textfield name="password" value="%{editUser.password}" label="password"/>
			<s:iterator value="roles" var="r"></s:iterator>
			<s:hidden name="r.id" value="%{}" />
			<s:hidden name="address" value="%{editUser.address}" />
			<s:submit></s:submit>
		</s:form>
	</div>
	
	<s:debug></s:debug>
</body>
</html>