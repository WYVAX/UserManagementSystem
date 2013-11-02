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
<h1>User Home</h1>
<h2>Welcome, <s:property value="%{#session.user.fullName()}"/></h2>

<br>
go to registration page: 

<a href='<s:url action="regPage" namespace="/registration" /> '> Registration page</a>
<br>
Delete User:
<a href='<s:url action="deleteUser" namespace="/security" />'>delete user </a>

Logout: 
<a href='<s:url action="logout" namespace="/registration" /> '> Logout</a>

<br>
Has role admin? 
<s:property value='%{#session.user.hasRole("ADMIN")}'/>
<br>

<s:if test='%{#session.user.hasRole("ADMIN")}'>
<a href='<s:url action="adminDashboard" namespace="/security"/>'>Administration</a>
</s:if>
<s:else>

</s:else>

 
 <s:debug></s:debug>
</body>
</html>