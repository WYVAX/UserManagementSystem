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
		<table border="1">
			<tr>
				<th>All Addresses</th>
				<th>Room Number</th>
				<th>Street Address1</th>
				<th>Street Address2</th>
				<th>State</th>
				<th>Country</th>
			</tr>
			<s:iterator value="#session.user.address" var="addr" status="stat">
				<tr>
					<th>Address <s:property value="#stat.count" /></th>
					<td><s:property value="#addr.roomNumber" /></td>
					<td><s:property value="#addr.streetAddr" /></td>
					<td><s:property value="#addr.streetAddr2" /></td>
					<td><s:property value="#addr.state" /></td>
					<td><s:property value="#addr.country" /></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	
	<s:debug></s:debug>
</body>
</html>