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
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<sb:head includeScripts="true" includeScriptsValidation="true"
	includeStylesResponsive="true" />

<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}
p {
	font-size:16px;
}
.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
}
</style>
<title>Login Page</title>
</head>
<body>


	<div class="container">

		<s:form action="login" theme="bootstrap" cssClass="form-signin">
			<h2 class="form-signin-heading">Please sign in</h2>
			<s:textfield name="username" class="input-block-level"
				placeholder="username" label="input user name"
				tooltip="input username here" />

			<s:password name="password" class="input-block-level"
				placeholder="password" label="input password"
				tooltip="input username here" />

		<div>
			<s:submit cssClass="btn btn-large btn-primary" />

				 <a
					href='<s:url action="regPageMD" namespace="/registration"/>' class="btn btn-large  pull-right">
					<font color="red">Or Register HERE</font>
					</a>
</div>
		</s:form>
		<s:debug />

	</div>


</body>
</html>