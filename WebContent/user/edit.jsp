<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User</title>
</head>
<body>
	<h2>Edit user info below</h2>
		<s:form action="updateUser" namespace="/security" >
			<h3>User info</h5>
 			<s:textfield name="editUser.username" value="%{editUser.username}" label="username" key="username" readonly="true"/>
			<s:textfield name="editUser.firstName" value="%{editUser.firstName}" label="firstName" />
			<s:textfield name="editUser.middleName" value="%{editUser.middleName}" label="middleName" />
			<s:textfield name="editUser.lastName" value="%{editUser.lastName}" label="lastName" />
			<s:textfield name="editUser.email" value="%{editUser.email}" label="email"/>
			<s:textfield name="editUser.password" value="%{editUser.password}" label="password"/>
		
			<table>
			
			<s:iterator  value="%{editUser.address}" status="stat" var="add">
			<br>
			<td style="color:green"><b>Address <s:property value="#stat.index+1"/> </b></td>
			<td><hr> </td>
			 
			<td><s:hidden name="addresses(%{#add.id}).id" value="%{#add.id}" ></s:hidden></td>
				<td><s:textfield name="addresses(%{#add.id}).streetAddr" value="%{#add.streetAddr}" label="street address 1"></s:textfield></td>
				<td><s:textfield name="addresses(%{#add.id}).streetAddr2" value="%{#add.streetAddr2}" label="street address 2"></s:textfield></td>
				<td><s:textfield name="addresses(%{#add.id}).state" value="%{#add.state}" label="state"></s:textfield></td>
				<td><s:textfield name="addresses(%{#add.id}).country" value="%{#add.country}" label="country"></s:textfield></td>
				<td><s:textfield name="addresses(%{#add.id}).roomNumber" value="%{#add.roomNumber}" label="room number"></s:textfield></td>
			</s:iterator>
			</table>
 			<s:submit></s:submit>
		</s:form>

	
	<s:debug></s:debug>
</body>
</html>