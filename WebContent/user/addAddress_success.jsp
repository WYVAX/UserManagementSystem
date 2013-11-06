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
	Address Update/create successfully! 
		<table border="1">
			<tr>
				<th> Room Number </th>
				<th> Address line 1</th>
				<th> Address line 2</th>
				<th> state </th>
				<th> country </th>
			</tr>
			
			<tr>
				<td> <s:property value="newAddress.roomNumber"/></td>
				<td> <s:property value="newAddress.streetAddr"/></td>
				<td> <s:property value="newAddress.streetAddr2"/></td>
				<td> <s:property value="newAddress.state"/></td>
				<td> <s:property value="newAddress.country"/></td>
		</table>
	</div>
	<br>
	<a href='<s:url action="userHome" namespace="/registration"/>'>Return Home page</a>
	<s:debug></s:debug>
</body>
</html>