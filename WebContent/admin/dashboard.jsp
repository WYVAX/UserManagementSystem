<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<sb:head includeScripts="false" includeScriptsValidation="false"
	includeStylesResponsive="true" />
<style type="text/css">
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<title>Administration</title>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">

				<a class="brand" href="#">My App </a>


				<div class="nav-collapse">
					<ul class="nav">
						<s:url var="index_url" action="userHome" namespace="/security" />
						<li class="active"><s:a href="%{index_url}">Home</s:a></li>
						<s:url var="admin_url" action="adminDashboard"
							namespace="/security" />
						<li><s:a href="%{admin_url}">Administration</s:a></li>
					</ul>

				</div>
				<p class="navbar-text pull-right">
					<a href='<s:url action="logout" namespace="/registration" /> '>Logout</a>
				</p>
			</div>

		</div>

	</div>



	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Form Layouts</li>
						<s:url var="index_url" action="index" />
						<li class="active"><s:a href="%{index_url}">Horizontal Form Layout</s:a></li>
						<s:url var="vertical_url" action="vertical" />
						<li><s:a href="%{vertical_url}">Vertical Form Layout</s:a></li>
						<s:url var="validation_url" action="validation" />
						<li><s:a href="%{validation_url}">Client Validation</s:a></li>
						<s:url var="advanced_url" action="advanced" />
						<li><s:a href="%{advanced_url}">Advanced Examples</s:a></li>
						<s:url var="jquery_url" action="jquery" />
						<li><s:a href="%{jquery_url}">Struts2 jQuery UI Form Elements</s:a></li>
						<s:url var="custom_url" action="custom" />
						<li><s:a href="%{custom_url}">With Custom Theme</s:a></li>
					</ul>
				</div>
			</div>

			<!-- Right panel start from here -->
			<div class="span9">
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

			</div>
		</div>
	</div>

</body>

</html>
