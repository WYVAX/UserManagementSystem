<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html lang="en">
<head></head>
<body>
			<!-- Right panel start from here -->
				<div class="hello-unit">
					<h1>
						Welcome,
						<s:property value="%{session_user.fullName()}" />
					</h1>

				</div>


				<p>
					Edit users: <a
						href='<s:url action="userList" namespace="/security" />'
						class="btn">edit users </a>
				<div>
					Go back to user home: <a
						href='<s:url action="userHome" namespace="/security" />'
						class="btn">UserHome </a>
				</div>

				<a href='<s:url action="logout" namespace="/registration" /> '
					class="btn"> Logout</a>

				<div id="footer" style="color: red; clear: both">
					<s:debug></s:debug>
				</div>


</body>

</html>
