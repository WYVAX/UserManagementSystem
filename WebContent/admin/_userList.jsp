<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div>
		<table
			class="table table-striped table-bordered table-condensed table-hover">
			<tr>
				<th>username</th>
				<th>first name</th>
				<th>middle name</th>
				<th>last name</th>
				<th>email</th>
				<th>Operations</th>
			</tr>
			<s:iterator value="allUsers" var="user" status="stat">
				<tr>
					<td><s:property value="#user.username" /></td>
					<td><s:property value="#user.firstName" /></td>
					<td><s:property value="#user.middleName" /></td>
					<td><s:property value="#user.lastName" /></td>
					<td><s:property value="#user.email" /></td>
					<td><a
						href='<s:url action="editUser" namespace="/security">
							<s:param name="user_id" value="#user.username"/>
						</s:url>'>edit</a>
						or <s:url id="delUser" action="deleteUser" namespace="/security">
							<s:param name="user_id" value="#user.username" />
						</s:url> <s:a href="%{delUser}" onclick="return confirmDel()">delete</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>

	<s:debug></s:debug>
</body>
</html>