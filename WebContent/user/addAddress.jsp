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
		<s:form action="addAddress" namespace="/security">
			<s:textfield name="newAddress.id" value="%{newAddress.id}"
				label="address id" readonly="true"/>
			<s:textfield name="newAddress.streetAddr"
				value="%{newAddress.streetAddr}" label="address line 1" />
			<s:textfield name="newAddress.streetAddr2"
				value="%{newAddress.streetAddr2}" label="address line 2" />
			<s:textfield name="newAddress.state" value="%{newAddress.state}"
				label="state" />
			<s:textfield name="newAddress.country" value="%{newAddress.country}"
				label="country" />
			<s:textfield name="newAddress.roomNumber"
				value="%{newAddress.roomNumber}" label="room number" />
			<s:hidden name="user_id" value="%{user_id}" />
			<s:submit></s:submit>
		</s:form>
	</div>

	<s:debug></s:debug>
</body>
</html>