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

User
<s:property value="editUser.fullName()"/>
has been updated successfully! 
<br>

<a href='<s:url action="userList" namespace="/security"/>'> Back to User User List</a>
<br>
<a href='<s:url action="adminDashboard" namespace="/security"/>'> Back to User Admin Homepage</a>	
	<s:debug></s:debug>
</body>
</html>