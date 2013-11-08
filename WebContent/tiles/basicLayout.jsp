<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>

	<!-- navigation bar start here -->
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
						<li><s:a href="%{admin_url}">administration</s:a></li>

					</ul>

				</div>
				<p class="navbar-text pull-right">
					<a href='<s:url action="logout" namespace="/registration" /> '>Logout</a>
				</p>
			</div>
		</div>
	</div>

	<!-- content container start here -->
	<div class="container-fluid">
		<div class="row-fluid">

			<!-- Left Side bar start here -->
			<div class="span3">
				<tiles:insertAttribute name="sidebar"></tiles:insertAttribute>
			</div>

			<!-- Right panel start from here -->
			<div class="span9">
				<tiles:insertAttribute name="content"></tiles:insertAttribute>
			</div>
			
			<div id="footer" style="color: red; clear: both">
				<s:debug></s:debug>
			</div>

		</div>
	</div>


</body>
</html>