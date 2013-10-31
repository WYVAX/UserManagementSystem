<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
</head>
<body>
Registration Page. 
		<s:form action="regProcess">
    	<s:textfield name="firstName" label="input first name"/>
    	<s:textfield name="middleName" label="input middle name"/>
    	<s:textfield name="lastName" label="input last name"/>
    	<s:password name="password" label="input password"/>
    	<s:password name="password2" label="re-enter your password"/>
    	<br>
    	<p> Please enter your address:
    	<br>
    	<s:textfield name="roomNumber" label=" apartment/room number"/>
    	<s:textfield name="streetAddr" label=" street address"/>
    	<s:textfield name="streetAddr2" label=" street address line 2"/>
    	<s:textfield name="state" label=" state"/>
    	<s:textfield name="country" label=" country"/>
    	<s:submit/>
		</s:form>

</body>
</html>