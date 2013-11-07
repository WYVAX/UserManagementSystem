<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div>
	      <table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
			<tr>
				<th>All Addresses</th>
				<th>Room Number</th>
				<th>Street Address1</th>
				<th>Street Address2</th>
				<th>State</th>
				<th>Country</th>
				<th>edit</th>
			</tr>
			<s:iterator value="session_user.address" var="addr" status="stat">
				<tr>
					<th>Address <s:property value="#stat.count" /></th>
					<td><s:property value="#addr.roomNumber" /></td>
					<td><s:property value="#addr.streetAddr" /></td>
					<td><s:property value="#addr.streetAddr2" /></td>
					<td><s:property value="#addr.state" /></td>
					<td><s:property value="#addr.country" /></td>
					<td><a
						href='<s:url action="address" namespace="/security" >
									<s:param name="user_id" value="session_user.username"/>
									<s:param name="address_id" value="#addr.id" />
								</s:url>'>edit
					</a></td>
				</tr>
			</s:iterator>
		</table>
		<a
			href='<s:url action="address" namespace="/security" >
					<s:param name="user_id" value="session_user.username"/>
		</s:url>'>
			Add an address</a>
	</div>

	<s:debug></s:debug>
</body>
</html>