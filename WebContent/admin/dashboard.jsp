<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Home page</title>
</head>
<body>
<h1>Administrator DashBoard</h1>
<h2>Welcome, <s:property value="%{#session.user.fullName()}"/></h2>

<br>
Delete User:
<a href='<s:url action="deleteUser" namespace="/security" />'>delete user </a>

<div>
Go back to user home:
<a href='<s:url action="userHome" namespace="/registration" />'>delete user </a>
</div>
<br>
Logout: 
<a href='<s:url action="logout" namespace="/registration" /> '> Logout</a>
<s:debug></s:debug>
</body>
</html>
