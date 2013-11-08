<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<sb:head includeScripts="false" includeScriptsValidation="false"
	includeStylesResponsive="true" />
<style type="text/css">
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>

</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">

				<a class="brand" href="#">My App </a>


				<div class="nav-collapse">
					<ul class="nav">
						<s:url var="index_url" action="userHome" />
						<li class="active"><s:a href="%{index_url}">Home</s:a></li>
						<s:url var="about_url" action="" />
						<li><s:a href="%{about_url}">About</s:a></li>
						<li><a href="http://code.google.com/p/struts2-bootstrap/">Project</a></li>
					</ul>

				</div>
				<p class="navbar-text pull-right">
					<a href='<s:url action="logout" namespace="/registration" /> '>Logout</a>
				</p>
			</div>

		</div>

	</div>



Registration Page. 
		<s:form action="regProcess" namespace="/registration">
		<s:textfield name="username" label="input user name"/>
    	<s:textfield name="firstName" label="input first name"/>
    	<s:textfield name="middleName" label="input middle name"/>
    	<s:textfield name="lastName" label="input last name"/>
    	<s:textfield name="email" label="input email"/>
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
<s:debug></s:debug>
</body>
</html>