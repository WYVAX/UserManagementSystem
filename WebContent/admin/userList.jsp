<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Home page</title>
<script type="text/javascript">
function confirmDel(){
	var ans=window.confirm("Are you sure to delete?");
	if(ans) return true;
	else return false;
}
</script>
</head>
<body>
	<div>
		<table>
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
					<td><a href='<s:url action="editUser" namespace="/security">
							<s:param name="user_id" value="#user.username"/>
						</s:url>'>edit</a> 
						or 
						<s:url id="delUser" action="deleteUser" namespace="/security">
							<s:param name="user_id" value="#user.username"/> 
						</s:url>
						<s:a href="%{delUser}" onclick="return confirmDel()">delete</s:a>
						</td>
				</tr>
			</s:iterator>
		</table>
	</div>
	
	<s:debug></s:debug>
</body>
</html>